import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class TCPServer {  
    private static final Object client = null;

	public static void main(String[] args) {  
        try {  
            ServerSocket server = new ServerSocket(8887); 
           
            Socket socket = server.accept();  
            new ServerReceiver(server,socket).start();  
            new Server(socket).start();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
    }  
}  