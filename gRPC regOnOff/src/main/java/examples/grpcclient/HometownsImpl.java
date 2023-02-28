
package examples.grpcclient;

import com.google.protobuf.Empty;
import com.google.protobuf.Message;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.json.JSONObject;
import service.Hometown;
import service.HometownOrBuilder;
import service.HometownsGrpc;
import service.HometownsReadResponse;
import service.HometownsSearchRequest;
import service.HometownsWriteRequest;
import service.HometownsWriteResponse;

/**
 *
 * @author alhaj05
 */
public class HometownsImpl extends HometownsGrpc.HometownsImplBase{
    
    
    List<Hometown> home = new ArrayList<Hometown>();

    @Override
    public void write(HometownsWriteRequest req, StreamObserver<HometownsWriteResponse> responseObserver) {
         //Hometown t = req.getHometown();
        
                    
        home.add(req.getHometown());
        HometownsWriteResponse.Builder response = HometownsWriteResponse.newBuilder();
        response.setIsSuccess(true);
         
        response.setError("unable to sava...");
        
        HometownsWriteResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void search(HometownsSearchRequest req, StreamObserver<HometownsReadResponse> responseObserver) {
       //System.out.println("city entred: "+req.getCity());
        HometownsReadResponse.Builder response = HometownsReadResponse.newBuilder();
      
        
        for(int i = 0; i <home.size();i++){
            //requstCity = this.home.get(i);
            if(req.getCity().equals(home.get(i).getCity())){
               String name = home.get(i).getName();
               String city = home.get(i).getCity();
               String region = home.get(i).getRegion();
               
               Hometown t = Hometown.newBuilder()
                 .setName(name)
                 .setCity(city)
                 .setRegion(region)
              .build(); 
               response.addHometowns(home.get(i));
               
            }
           
            
        }
        
        response.setIsSuccess(true);
        
        HometownsReadResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void read(Empty request, StreamObserver<HometownsReadResponse> responseObserver) {
        System.out.println("Despling the list all hometowns...");
        HometownsReadResponse.Builder response = HometownsReadResponse.newBuilder();
        for(Hometown i : home){
            response.addHometowns(i);
        }
        //System.out.println("homes: "+home.get(0));
        response.setIsSuccess(true);
        HometownsReadResponse resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
        
    }
    
    
}
