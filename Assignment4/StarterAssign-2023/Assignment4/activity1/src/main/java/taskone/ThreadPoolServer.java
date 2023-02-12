
package taskone;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author alhaj05
 */
public class ThreadPoolServer {
    public static void main(String[] args) throws Exception {
        int port;
        int poolSize;
        Socket sock = null;
        int id = 0;
        StringList strings = new StringList();

        if (args.length != 2) {
            // gradle runServer -Pport=9099 -q --console=plain
            System.out.println("Usage: gradle runServer -Pport=9099 -q --console=plain");
            System.exit(1);
        }
        port = -1;
        poolSize = -2;
        try {
            port = Integer.parseInt(args[0]);
            poolSize = Integer.parseInt(args[1]);

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started...");
        while (true) {
            System.out.println("Accepting a Request...");
            sock = server.accept();
            System.out.println("Server connected to client "+id);
            Performer performer = new Performer(sock, strings);
            id++;
            Executor task = Executors.newFixedThreadPool(poolSize);
            for(int i = 0; i < 5; i++){
                task.execute(performer);
            }
            
        }
            
               
        }catch (Exception e) {
                e.printStackTrace();
            }
        finally{
            if(sock != null) sock.close();
        }
    
     }
    
}
