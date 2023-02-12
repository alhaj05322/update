package server;

import buffers.RequestProtos.Logs;
import buffers.RequestProtos.Message;
import buffers.RequestProtos.Request;
import buffers.ResponseProtos.Entry;
import buffers.ResponseProtos.Response;
import buffers.ResponseProtos.Response.ResponseType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;

class SockBaseServer implements Runnable {
    static String logFilename = "logs.txt";
    static String leaderBoardFilename = "leader.txt";
    static Response.Builder leaderBoard = Response.newBuilder().setResponseType(Response.ResponseType.LEADER);
    Game game;
    Socket clientSocket;
    InputStream in = null;
    OutputStream out = null;

    public SockBaseServer(Socket sock, Game game) {
        this.clientSocket = sock;
        this.game = game;
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
        } catch (Exception e) {
            System.out.println("Error in constructor: " + e);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        initLeaderFile();
        initLeaderboard();
        int port = 9099; 
        if (argsCheck(args)) {
            port = getPort(args);
        }
        
        ServerSocket serv = connectServerSocket(port);
        while (true) {
            try {
                Socket clientSocket = serv.accept();
                
                Runnable serverRunnable = new SockBaseServer(clientSocket, game);
                Thread serverThread = new Thread(serverRunnable);
                serverThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private static void initLeaderFile() {
        try {
            File leaderFile = new File(leaderBoardFilename);
            if (leaderFile.createNewFile()) {
                System.out.println("File created: " + leaderFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void initLeaderboard() {
        String line;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(leaderBoardFilename)); BufferedReader br = new BufferedReader(isr)) {
            while ((line = br.readLine()) != null) {
                if (!line.equals("")) {
                    String[] lineArray = line.split(",");
                    String element1 = lineArray[0];
                    String element2 = lineArray[1];

                    int wins = 0;
                    try {
                        wins = Integer.parseInt(element2);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    addEntry(element1, wins);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean argsCheck(String[] args) {
        if (args.length != 1) {
            System.out.println("Expected arguments: <port(int)>");
            System.exit(1);
        }
        return true;
    }

    private static int getPort(String[] args) {
        int port = -1;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be integer");
            System.exit(2);
        }
        return port;
    }

    private static ServerSocket connectServerSocket(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }
        return serverSocket;
    }

    private synchronized static void addEntry(String name, int wins) {
        Entry leader = Entry.newBuilder().setName(name).setWins(wins).build();
        leaderBoard.addLeader(leader);
    }

    public void run() {

        String name = "";

        try {
            boolean quit = false;
            while (!quit) {

                Request request;
                Response response;

                if (clientSocket.isConnected()) {
                    request = Request.parseDelimitedFrom(in);
                } else {
                    break;
                }

                switch (request.getOperationType()) {
                    case NAME:
                        name = request.getName();
                        writeToLog(name, Message.CONNECT);
                        response = buildGreetingRes(name);
                        break;
                    case LEADER:
                        leaderBoard.getLeaderList();
                        response = buildLeaderRes();
                        break;
                    case NEW:
                        game.newGame(); 
                        response = buildNewRes();
                        writeToLog(name, Message.START);   
                        break;
                    case ROWCOL:
                        int row = -99;
                        int column = -99;
                        char c;
                        if (request.hasRow() && request.hasColumn()) {
                            row = request.getRow();
                            column = request.getColumn();
                            
                        }
                        if (game.hasValidLocation(row, column)) {
                            int foundLocations = game.getIdx();
                            game.replaceOneCharacter(row, column);

                            // Win condition
                            if (game.getIdx() == game.getIdxMax()) {   
                                boolean nameExists = false;
                                List<Entry> leaderList = leaderBoard.getLeaderList();
                                if (!leaderList.isEmpty()) {                              
                                    for (Entry entry : leaderList) {
                                        if (entry.getName().equalsIgnoreCase(name)) {
                                            String entryName = entry.getName();
                                            int entryWins = entry.getWins();
                                            entryWins += 1;
                                            addEntry(entryName, entryWins);
                                            leaderBoard.removeLeader(leaderList.indexOf(entry)).build();   
                                            writeToLeaderLog(name);
                                            nameExists = true;
                                            break;
                                        }
                                    }
                                    if (!nameExists || leaderList.isEmpty()) {
                                        addEntry(name, 1);
                                        writeToLeaderLog(name);
                                    }
                                }

                                showLeaderboard(); 
                                response = buildWonRes();
                                writeToLog(name, Message.WIN);
                            } else if (game.getIdx() > foundLocations) {
                                response = buildTaskRes(true); 
                            } else {
                                response = buildTaskRes(false); 
                            }
                        } else {
                            response = buildErrorRes("Error! input must integers.");
                        }
                        System.out.println("Image: \n" + game.showBoard());
                        break;
                    case QUIT:
                        response = buildByeRes(name);
                        quit = true;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + request);
                }

                if (response.getResponseType().equals(ResponseType.WON)) {
                    game.setWon();
                }
                response.writeDelimitedTo(out);
            }

        } catch (Exception ex) {
            System.out.println("Client " + name + " connection has been terminated.");
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                System.out.println("Client got disconnected");
            }
        }
    }

   /**
     * Writing a new entry to our log
     * @param name - Name of the person logging in
     * @param message - type Message from Protobuf which is the message to be written in the log (e.g. Connect) 
     * @return String of the new hidden image
     */
    public static void writeToLog(String name, Message message){
        try {
            // read old log file 
            Logs.Builder logs = readLogFile();

            // get current time and data
            Date date = java.util.Calendar.getInstance().getTime();
            System.out.println(date);

            // we are writing a new log entry to our log
            // add a new log entry to the log list of the Protobuf object
            logs.addLog(date.toString() + ": " +  name + " - " + message);

            // open log file
            FileOutputStream output = new FileOutputStream(logFilename);
            Logs logsObj = logs.build();

            // This is only to show how you can iterate through a Logs object which is a protobuf object
            // which has a repeated field "log"

            for (String log: logsObj.getLogList()){

                System.out.println(log);
            }

            // write to log file
            logsObj.writeTo(output);
        }catch(Exception e){
            System.out.println("Could not save in the file");
        }
    }

    /**
     * Reading the current log file
     * @return Logs.Builder a builder of a logs entry from protobuf
     */
    public static Logs.Builder readLogFile() throws Exception{
        Logs.Builder logs = Logs.newBuilder();

        try {
            // just read the file and put what is in it into the logs object
            return logs.mergeFrom(new FileInputStream(logFilename));
        } catch (FileNotFoundException e) {
            System.out.println(logFilename + ": File not found.");
            return logs;
        }
    }

    private synchronized Response buildGreetingRes(String name) {
        return Response.newBuilder().setResponseType(ResponseType.GREETING).setMessage("Hello " + name + " and welcome. Welcome to a simple game of battleship. ").build();
    }

    private synchronized Response buildLeaderRes() {
        return leaderBoard.build();
    }

    private synchronized Response buildNewRes() {
        return Response.newBuilder().setResponseType(ResponseType.PLAY).setBoard(game.getBoard()).setFlippedBoard("Select a row and column.").build();
    }

    public synchronized static void writeToLeaderLog(String name) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(leaderBoardFilename));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            boolean found = false;
            while ((line = file.readLine()) != null) {
                if (line.contains(name)) {
                    String[] contents = line.split(",");
                    int currWins = Integer.parseInt(contents[1]);
                    currWins += 1;
                    line = contents[0] + "," + currWins;
                    found = true;
                }
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }

            if (!found) {
                while ((line = file.readLine()) != null) {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                inputBuffer.append(name).append(",1");
            }
            file.close();
            FileOutputStream fileOut = new FileOutputStream(leaderBoardFilename);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }

    }

    private synchronized void showLeaderboard() {
        for (Entry lead : leaderBoard.getLeaderList()) {
            System.out.println(lead.getName() + ": " + lead.getWins());
        }
    }

    private synchronized Response buildWonRes() {
        return Response.newBuilder().setResponseType(ResponseType.WON).setBoard(game.getBoard()).setMessage("well done").build();
    }

    private synchronized Response buildTaskRes(boolean hasEval) {
        if (hasEval) {
            return Response.newBuilder().setResponseType(ResponseType.PLAY).setBoard(game.getBoard()).setEval(true).setFlippedBoard("\nYou found a match\n").build();
        }
        return Response.newBuilder().setResponseType(ResponseType.PLAY).setBoard(game.getBoard()).setEval(false).setFlippedBoard("\nNo match\n").build();
    }

    private synchronized Response buildErrorRes(String errorMessage) {
        return Response.newBuilder().setResponseType(ResponseType.ERROR).setMessage(errorMessage).build();
    }

    private synchronized Response buildByeRes(String name) {
        return Response.newBuilder().setResponseType(ResponseType.BYE).setMessage("Good bye " + name).build();
    }

    public static Logs.Builder readLogFile(String fileName) throws Exception {
        Logs.Builder logs = Logs.newBuilder();

        try {
            return logs.mergeFrom(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": File not found.  Creating a new file.");
            return logs;
        }
    }

}

