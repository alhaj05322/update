
package examples.grpcclient;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.net.InetAddress;
import java.util.HashMap;
import service.AddressPingGrpc;
import service.PingAdressReq;
import service.PingAdressRes;

import service.PingSerchReq;
import service.PingSerchRes;

/**
 *
 * @author alhaj05
 */
public class AddressPingImpl extends AddressPingGrpc.AddressPingImplBase{
    public InetAddress pingAddress(String host){
        InetAddress address = null;
        try{
            address = InetAddress.getByName(host);
            
        }catch(Exception e){
            System.out.println(e);
        }
        return address;
    }
    HashMap<String, String> map = new HashMap<>();
   

    @Override
    public void getIpAddress(PingSerchReq req, StreamObserver<PingSerchRes> responseObserver) {
         PingSerchRes.Builder response =  PingSerchRes.newBuilder();
       for(int i = 0; i < map.size(); i++){
           if(!map.isEmpty()){
              
               response.setIpAdress(map.get(req.getName()));
           }
       }
       
        PingSerchRes resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void pingAddress(PingAdressReq req, StreamObserver<PingAdressRes> responseObserver) {
        
       map.put(req.getName(),pingAddress(req.getHost()).toString());
       System.out.println("ip is: "+map.get("google"));
       PingAdressRes.Builder response = PingAdressRes.newBuilder();
       response.setIsSuccess(true);
       response.setError("unable to ping the given address: "+req.getHost());
       
       PingAdressRes resp =response.build();
       responseObserver.onNext(resp);
       responseObserver.onCompleted();
    }
    
    
}
