  
import java.io.IOException;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
public class TCPClient {  
public static void main(String[] args) {  
    try {  
        Socket client = new Socket("127.0.0.1", 8887); 
        System.out.println("Specify IP address of destination chat program£º" + client.toString()); 
        new Client(client).start();  
        new ClientReceive(client).start();  
    } catch (UnknownHostException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    } catch (IOException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    }  
}  
}  