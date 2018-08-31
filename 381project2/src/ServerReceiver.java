import java.io.DataInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.net.ServerSocket;  
import java.net.Socket;  
//server receive the message  
public class ServerReceiver extends Thread{  
      
    public ServerSocket server;  
    public Socket socket;  
      
    public ServerReceiver(){  
        super();  
    }  
      
    public ServerReceiver(ServerSocket server,Socket socket){  
        this.server=server;  
        this.socket=socket;  
    }  
      
    public void run(){  
        try {  
            InputStream i = socket.getInputStream();  
            DataInputStream is =new DataInputStream(i);  
            String s;  
            s = is.readUTF();  
            //Close the application when enter bye  
            while(!("client:bye".equals(s))){  
                if(socket.isClosed()==false)  
                {  
                    System.out.println(s);  
                    s=is.readUTF();  
                }  
                else{  
                    break;  
                }  
            }  
            System.out.println(s);  
            System.out.println();  
            is.close();  
            i.close();  
            socket.close();  
            server.close();  
        } catch (IOException e) {  
        	//The exception caused by port shutdown is not handled 
        }catch(Exception e){  
            System.out.println("chat stop");  
        }  
    }  
}  