
package examples.grpcclient;

//import service.CaesarGrpc;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Random;
import service.CaesarGrpc;
import service.PasswordList;
import service.PasswordReq;
import service.PasswordRes;
import service.SaveReq;
import service.SaveRes;


/**
 *
 * @author alhaj05
 */
public class CaesarImpl extends CaesarGrpc.CaesarImplBase {
    
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random(2);
    int randkey =3;
    public String encryptCiper(String pass, int key){
        
        if(key > 26){
            key = key % 26;
        }else if(key < 0){
            key = (key % 26) + 26;
        }
        String encText ="";
        for(int i = 0 ; i < pass.length() ; i++){
            char ch = pass.charAt(i);
     
                char c = (char) (ch + key);
                encText +=c;
            
            
        }
        return encText;
    }
    
    public String decryptCiper(String pass, int key){
        
        if(key > 26){
            key = key % 26;
        }else if(key < 0){
            key = (key % 26) + 26;
        }
        String encText = null;
        for(int i = 0 ; i < pass.length() ; i++){
            char ch = pass.charAt(i);
     
                char c = (char) (ch - key);
                encText +=c;
            
            
        }
        return encText.substring(4);
    }


    @Override
    public void listPasswords(Empty req, StreamObserver<PasswordList> responseObserver) {
       //Empty empt = Empty.newBuilder().build();
       System.out.println("Despling the list of passwars names...");
       PasswordList.Builder response =  PasswordList.newBuilder();
       for(String i : map.keySet()){
         if(!map.isEmpty()){
              response.addPassList(i);
         }else{
             
         }
       }
       
       PasswordList resp = response.build();
       responseObserver.onNext(resp);
       responseObserver.onCompleted();
    }

    @Override
    public void decrypt(PasswordReq req, StreamObserver<PasswordRes> responseObserver) {
        
        
        PasswordRes.Builder response = PasswordRes.newBuilder();
        String decpass = this.decryptCiper(map.get(req.getName()), randkey);
        System.out.println("passward after decrption... " + decpass);
        response.setPassword(decpass);
        PasswordRes resp = response.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void encrypt(SaveReq req, StreamObserver<SaveRes> responseObserver) {
        
        
       
       String ecryptPass = this.encryptCiper(req.getPassword(), randkey);
       
       System.out.println("passward after encryption....."+ ecryptPass);
       map.put(req.getName(), ecryptPass);
       SaveRes.Builder response = SaveRes.newBuilder();
       response.setOk(true);
       response.setError("Unable to save passward..");
       SaveRes resp =response.build();
       responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
    
    
    
}
