package client;

import buffers.RequestProtos.Request;
import buffers.ResponseProtos.Entry;
import buffers.ResponseProtos.Response;

import java.io.*;
import java.net.Socket;

class SockBaseClient {
    public static int check(String c){
        int num=0;
            switch(c){
                case "a":
                    num=0;
                    break;
                case "b":
                    num=1;
                    break;
                case "c":
                    num=2;
                    break;
                case "d":
                    num = 3;
                    break;
                default:
                    System.out.println("Enter valid input...");
                    break;
            }
            return num;
        }


    public static void main(String[] args) throws Exception {
        String host = null;
        int port = -1;

        if (argsCheck(args)) {
            host = args[0];
            port = getPort(args);
        }
        
        
        boolean displayMenu = true;
        boolean hasDisconnect = false;
        boolean exitGame = false;
        try (Socket serverSock = new Socket(host, port); OutputStream out = serverSock.getOutputStream(); InputStream in = serverSock.getInputStream()) {
            System.out.println("Please provide your name for the server.");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String strToSend = stdin.readLine();
            Request request = null;
            Response response = null;
            if (serverSock.isConnected()) {
                request = buildNameReq(strToSend);                
                request.writeDelimitedTo(out);                                              
                response = getResponse(in);   
            } else {
                serverSock.close();
            }

            if (response != null) {
                if (response.getResponseType() == Response.ResponseType.GREETING) {
                    System.out.println(response.getMessage());
                }
            }
            while (!hasDisconnect) {
                int selection = -99;
                if (displayMenu) {
                    while (selection == -99) {
                        System.out.println("* \nWhat would you like to do? \n 1 - to see the leader board \n 2 - to enter a game \n 3 - quit the game");
                        String menuSelection = stdin.readLine();
                        try {
                            int parseSelection = Integer.parseInt(menuSelection);
                            if (checkBounds(parseSelection)) {
                                selection = parseSelection;

                                switch (selection) {
                                    case 1:
                                        request = buildLeaderReq();
                                        break;
                                    case 2:
                                        request = buildGameReq();    
                                        displayMenu = false;
                                        break;
                                    case 3:
                                        request = buildQuitReq();      
                                        hasDisconnect = true;
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + selection);
                                }
                            }
                        } catch (IOException | NumberFormatException e) {
                            System.out.println("Enter a valid number");
                        }
                    }
                }
                if (request != null && response != null && serverSock.isBound()) {
                    request.writeDelimitedTo(out);
                    response = getResponse(in);
                } else {
                    serverSock.close();
                }
                if (response != null) {
                    switch (response.getResponseType()) {
                        case LEADER:
                            for (Entry lead : response.getLeaderList()) {
                                System.out.println(lead.getName() + ":" + lead.getWins());
                            }
                            break;
                        case PLAY:
                            System.out.println(response.getFlippedBoard());
                            System.out.println(response.getBoard());
                            int inRow = -99;
                            boolean validRow = false;
                            int inColumn = -99;
                            boolean validColumn = false;
                            while (!validRow && !validColumn) {
                                System.out.println("Please enter the location of the tile.");
                                System.out.println("For ex: a1");
                                String str = stdin.readLine();
                                String[] str2 = str.split("");
                                String rowInput = str2[0];
                                String columnInput = str2[1];

                                // check for null input
                                if (rowInput != null) {
                                    if (!isExit(rowInput)) {
                                        try {
                                            inRow = check(columnInput);
                                            validRow = true;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Enter a valid integer for Row.");
                                        }
                                    } else {
                                        exitGame = true;
                                        displayMenu = true;
                                        break;
                                    }
                                }
                                if (columnInput != null) {
                                    if (!isExit(columnInput)) {
                                        try {
                                            inColumn = Integer.parseInt(columnInput);
                                            validColumn = true;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Enter a valid integer for Column.");
                                        }
                                    } else {
                                        exitGame = true;
                                        displayMenu = true;
                                        break;
                                    }
                                }
                            }                                                  
                            if (exitGame) {
                                request = buildQuitReq();
                            } else {
                                request = buildTaskReq(inRow, inColumn);
                            }
                            break;
                        case WON:
                            System.out.println(response.getMessage());
                            System.out.println(response.getBoard());
                            displayMenu = true;
                            break;
                        case ERROR:
                            System.out.println(response.getMessage());
                            break;
                        case BYE:
                            System.out.println(response.getMessage());
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + response.getResponseType());
                    }
                }

                if (exitGame) {
                    request.writeDelimitedTo(out);                               
                    response = Response.parseDelimitedFrom(in);      
                }

            }
        }
    }
    private static boolean argsCheck(String[] args) {
        if (args.length != 2) {
            System.out.println("Expected arguments: <host(String)> <port(int)>");
            System.exit(1);
        }
        return true;
    }

    private static int getPort(String[] args) {
        int port = -1;
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be integer");
            System.exit(2);
        }
        return port;
    }

    private static Request buildNameReq(String name) {
        return Request.newBuilder().setOperationType(Request.OperationType.NAME).setName(name).build();
    }

    private synchronized static Response getResponse(InputStream in) throws IOException {
        return Response.parseDelimitedFrom(in);
    }

    private static boolean checkBounds(int i) throws IOException {
        return i > 0 && i < 4;
    }

    private static Request buildLeaderReq() {
        Request op;
        op = Request.newBuilder().setOperationType(Request.OperationType.LEADER).build();
        return op;
    }

    private static Request buildGameReq() {
        Request op;
        op = Request.newBuilder().setOperationType(Request.OperationType.NEW).build();
        return op;
    }

    private static Request buildQuitReq() {
        Request op;
        op = Request.newBuilder().setOperationType(Request.OperationType.QUIT).build();
        return op;
    }

    private static boolean isExit(String input) {
        return input.equalsIgnoreCase("exit");
    }

    private static Request buildTaskReq(int row, int column) {
        Request op;
        op = Request.newBuilder().setOperationType(Request.OperationType.ROWCOL).setRow(row).setColumn(column).build();
        return op;
    }
}
