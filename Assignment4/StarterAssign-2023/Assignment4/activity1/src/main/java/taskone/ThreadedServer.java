
package taskone;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alhaj05
 */
public class ThreadedServer {
    
     public static void main(String[] args) throws Exception {
        int port;
        Socket sock = null;
        int id = 0;
        StringList strings = new StringList();

        if (args.length != 1) {
            // gradle runServer -Pport=9099 -q --console=plain
            System.out.println("Usage: gradle runServer -Pport=9099 -q --console=plain");
            System.exit(1);
        }
        port = -1;
        try {
            port = Integer.parseInt(args[0]);

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started...");
        while (true) {
            System.out.println("Accepting a Request...");
            sock = server.accept();
            System.out.println("Server connected to client "+id);
            Performer performer = new Performer(sock, strings);
            id++;
            Thread task = new Thread(performer);
            task.start();
        }
            
               
        }catch (Exception e) {
                e.printStackTrace();
            }
        finally{
            if(sock != null) sock.close();
        }
    
     }
    
}
