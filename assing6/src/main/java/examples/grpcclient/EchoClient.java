package examples.grpcclient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import service.*;
import test.TestProtobuf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.protobuf.Empty; // needed to use Empty
import java.util.Scanner;

// just to show how to use the empty in the protobuf protocol
// Empty empt = Empty.newBuilder().build();
/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class EchoClient {

    private final EchoGrpc.EchoBlockingStub blockingStub;
    private final JokeGrpc.JokeBlockingStub blockingStub2;
    private final RegistryGrpc.RegistryBlockingStub blockingStub3;
    //private final RecipeGrpc.RecipeBlockingStub blockingStub4;
    private final CaesarGrpc.CaesarBlockingStub blockingStub4;
    private final HometownsGrpc.HometownsBlockingStub blockingStub5;
    private final AddressPingGrpc.AddressPingBlockingStub blockingStub6;

    /**
     * Construct client for accessing server using the existing channel.
     */
    public EchoClient(Channel channel, Channel regChannel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
        // responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to
        // reuse Channels.
        blockingStub = EchoGrpc.newBlockingStub(channel);
        blockingStub2 = JokeGrpc.newBlockingStub(channel);
        blockingStub3 = RegistryGrpc.newBlockingStub(regChannel);
        //blockingStub4 = RecipeGrpc.newBlockingStub(channel);
        blockingStub4 = CaesarGrpc.newBlockingStub(channel);
        blockingStub5 = HometownsGrpc.newBlockingStub(channel);
        blockingStub6 = AddressPingGrpc.newBlockingStub(channel);
    }

    public void askServerToParrot(String message) {

        ClientRequest request = ClientRequest.newBuilder().setMessage(message).build();
        ServerResponse response;
        try {
            response = blockingStub.parrot(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e.getMessage());
            return;
        }
        System.out.println("Received from server: " + response.getMessage());
    }

    public void askForJokes(int num) {
        JokeReq request = JokeReq.newBuilder().setNumber(num).build();
        JokeRes response;

        try {
            response = blockingStub2.getJoke(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
        System.out.println("Your jokes: ");
        for (String joke : response.getJokeList()) {
            System.out.println("--- " + joke);
        }
    }

    public void askForHomeTown(String city) {

        HometownsSearchRequest request = HometownsSearchRequest.newBuilder().setCity(city).build();
        HometownsReadResponse response;

        try {
            response = blockingStub5.search(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
        System.out.println(response.getIsSuccess());
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("List of Student From: " + city);
        for (int i = 0; i < response.getHometownsCount(); i++) {

            System.out.println("Name: " + response.getHometowns(i).getName() + " city: "
                    + response.getHometowns(i).getCity() + " Region: " + response.getHometowns(i).getRegion());

        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }

    public void listOfHomeTown() {

         Empty empt = Empty.newBuilder().build();
        HometownsReadResponse response;

        try {
            response = blockingStub5.read(empt);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
        
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println(response.getIsSuccess());
        System.out.println("List of HomeTowns: " );
        for (int i = 0; i < response.getHometownsCount(); i++) {

            System.out.println("Name: " + response.getHometowns(i).getName() + " city: "
                    + response.getHometowns(i).getCity() + " Region: " + response.getHometowns(i).getRegion());

        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }
    public void askForPassward() {
        Empty empt = Empty.newBuilder().build();
        PasswordList response;

        try {
            response = blockingStub4.listPasswords(empt);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");

        System.out.println("List of All passward names: ");
        for (int i = 0; i < response.getPassListCount(); i++) {
            System.out.println(response.getPassList(i));
        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }

    public void askForDec(String name) {
        PasswordReq request = PasswordReq.newBuilder().setName(name).build();
        PasswordRes response;

        try {
            response = blockingStub4.decrypt(request);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("Your Passwatd is : ");
        //for (String joke : response.getJokeList()) {
        System.out.println(response.getPassword());
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        //}
    }

    public void askForPing(String name, String host) {
        PingAdressReq request = PingAdressReq.newBuilder()
                .setHost(host)
                .setName(name)
                .build();
        PingAdressRes response = null;

        try {
            response = blockingStub6.pingAddress(request);
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println(response.getIsSuccess());
            System.out.println("Ip for " + host + " saved under " + name);
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println(" ");
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            System.out.println(response.getError());
            return;
        }

    }

    public void serchForIp(String ip) {
        PingSerchReq request = PingSerchReq.newBuilder().setName(ip).build();
        PingSerchRes response;

        try {
            response = blockingStub6.getIpAddress(request);

        } catch (Exception e) {
            System.err.println("RPC failed: " + e);

            return;
        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("The ip for: " + ip + " is: " + response.getIpAdress());

        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println(" ");

    }

    public void setJoke(String joke) {
        JokeSetReq request = JokeSetReq.newBuilder().setJoke(joke).build();
        JokeSetRes response;

        try {
            response = blockingStub2.setJoke(request);
            System.out.println(response.getOk());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void addHometown(String name, String city, String region) {

        Hometown t = Hometown.newBuilder()
                .setName(name)
                .setCity(city)
                .setRegion(region)
                .build();
        HometownsWriteRequest request = HometownsWriteRequest.newBuilder().setHometown(t).build();
        HometownsWriteResponse response;

        try {
            response = blockingStub5.write(request);
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println(response.getIsSuccess());
            System.out.println("saved new Entry...");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println(" ");
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void encrypt(String name, String pass) {
        SaveReq request = SaveReq.newBuilder().setName(name).setPassword(pass).build();
        SaveRes response;
        try {

            response = blockingStub4.encrypt(request);
            if (response.getOk() == true) {
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                System.out.println(response.getOk());

                System.out.println("Passward saved....");
                System.out.println("--------------------------------------------");
                System.out.println("----------------------------------------");
                System.out.println(" ");
            } else {
                System.out.println(response.getError());
            }

        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void getServices() {
        GetServicesReq request = GetServicesReq.newBuilder().build();
        ServicesListRes response;
        try {
            response = blockingStub3.getServices(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void findServer(String name) {
        FindServerReq request = FindServerReq.newBuilder().setServiceName(name).build();
        SingleServerRes response;
        try {
            response = blockingStub3.findServer(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public void findServers(String name) {
        FindServersReq request = FindServersReq.newBuilder().setServiceName(name).build();
        ServerListRes response;
        try {
            response = blockingStub3.findServers(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 6) {
            System.out
                    .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <regOn(bool)>");
            System.exit(1);
        }
        int port = 9099;
        int regPort = 9003;
        int auto = 0;
        String host = args[0];
        String regHost = args[2];
        String message = args[4];
        try {
            port = Integer.parseInt(args[1]);
            regPort = Integer.parseInt(args[3]);
            
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be an integer");
            System.exit(2);
        }

        // Create a communication channel to the server, known as a Channel. Channels
        // are thread-safe
        // and reusable. It is common to create channels at the beginning of your
        // application and reuse
        // them until the application shuts down.
        String target = host + ":" + port;
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS
                // to avoid
                // needing certificates.
                .usePlaintext().build();

        String regTarget = regHost + ":" + regPort;
        ManagedChannel regChannel = ManagedChannelBuilder.forTarget(regTarget).usePlaintext().build();
        try {

            // ##############################################################################
            // ## Assume we know the port here from the service node it is basically set through Gradle
            // here.
            // In your version you should first contact the registry to check which services
            // are available and what the port
            // etc is.
            /**
             * Your client should start off with 1. contacting the Registry to
             * check for the available services 2. List the services in the
             * terminal and the client can choose one (preferably through
             * numbering) 3. Based on what the client chooses the terminal
             * should ask for input, eg. a new sentence, a sorting array or
             * whatever the request needs 4. The request should be sent to one
             * of the available services (client should call the registry again
             * and ask for a Server providing the chosen service) should send
             * the request to this service and return the response in a good way
             * to the client
             *
             * You should make sure your client does not crash in case the
             * service node crashes or went offline.
             */
            // Just doing some hard coded calls to the service node without using the
            // registry
            // create client
            EchoClient client = new EchoClient(channel, regChannel);
            
           
            // call the parrot service on the server
            client.askServerToParrot(message);

            // ask the user for input how many jokes the user wants
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Reading data using readLine
//      System.out.println("How many jokes would you like?"); // NO ERROR handling of wrong input here.
//      String num = reader.readLine();
//
//      // calling the joked service from the server with num from user input
//      client.askForJokes(Integer.valueOf(num));
            // adding a joke to the server
//      System.out.println("Enter recipe name");
//      String name = reader.readLine();
//      
//      System.out.println("Enter author name");
//      String author = reader.readLine();
//      System.out.println("Enter ingredian");
//      Ingredient ingredient = reader.read();
            //client.askForRecpe(name, author, ingredient);
            // showing 6 joked
            //client.askForJokes(Integer.valueOf(6));
            //int n =reader.read();
            Scanner scan = new Scanner(System.in);
            int choice;
            do {
                System.out.println("#### Avilable Services #####");
                System.out.println("please make a selection....");
                
                System.out.println("1:get joke.");
                System.out.println("2:save a passward.");
                System.out.println("3:get a passward by name.");
                System.out.println("4:print list of all passward.");
                System.out.println("5:Enter region info");
                System.out.println("6:search for person by city");
                System.out.println("7:List of HomeTowns");
                System.out.println("8:ping url");
                System.out.println("9:serch for Ip by name");
                
                System.out.println("0:exit!.");
                
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        // Reading data using readLine
                        System.out.println("How many jokes would you like?"); // NO ERROR handling of wrong input here.
                        String num = reader.readLine();

                        // calling the joked service from the server with num from user input
                        client.askForJokes(Integer.valueOf(num));
                        client.askForJokes(Integer.valueOf(6));
                        client.setJoke("I made a pencil with two erasers. It was pointless.");
                        break;
                    case 2:
                        System.out.println("Enter a name for the passward");
                        String name = reader.readLine();
                        System.out.println("Enter the passward");
                        String pass = reader.readLine();

                        client.encrypt(name, pass);
                        break;
                    case 3:
                        System.out.println("Enter a name to search for the passward");
                        String name1 = reader.readLine();
                        client.askForDec(name1);
                        break;
                    case 4:
                        client.askForPassward();
                        break;
                    case 5:
                        System.out.println("Enter your name ");
                        String personName = reader.readLine();
                        System.out.println("Enter your city");
                        String cityName = reader.readLine();
                        System.out.println("Enter your region");
                        String region = reader.readLine();
                        client.addHometown(personName, cityName, region);
                        break;
                    case 6:
                        System.out.println("Enter your a city name");
                        String city = reader.readLine();
                        client.askForHomeTown(city);
                        break;
                    case 7:
                        client.listOfHomeTown();
                        break;    
                    case 8:
                        System.out.println("Enter a the websit name(eg. Google): ");
                        String hostName = reader.readLine();
                        System.out.println("Enter a the websit URL(eg. www.Google.com): ");
                        String url = reader.readLine();
                        client.askForPing(hostName, url);
                        break;
                    case 9:
                        System.out.println("Enter the name: ");
                        String urlName = reader.readLine();
                        client.serchForIp(urlName);
                        break;
                    
                    case 0:
                        System.out.println("### Bye, see you soon ###");
                        System.out.println("------------------------------");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong input, please try again.");
                        System.out.println("------------------------------");
                        break;    

                }

            } while (true);

            // ############### Contacting the registry just so you see how it can be done
            //if (args[5].equals("true")) { 
            // Comment these last Service calls while in Activity 1 Task 1, they are not needed and wil throw issues without the Registry running
            // get thread's services
            //client.getServices(); // get all registered services 
            // get parrot
            //client.findServer("services.Echo/parrot"); // get ONE server that provides the parrot service
            // get all setJoke
            ////client.findServers("services.Joke/setJoke"); // get ALL servers that provide the setJoke service
            // get getJoke
            //client.findServer("services.Joke/getJoke"); // get ALL servers that provide the getJoke service
            // does not exist
            //client.findServer("random"); // shows the output if the server does not find a given service
            //}
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent
            // leaking these
            // resources the channel should be shut down when it will no longer be used. If
            // it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            regChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
