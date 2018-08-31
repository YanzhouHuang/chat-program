import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.net.Socket;  
import java.net.UnknownHostException;  
import java.util.Scanner;  
//server to send 
public class Server extends Thread{  
      
    public Socket socket;  
      
    public Server(){  
        super();  
    }  
  
    public Server(Socket socket){  
        this.socket = socket;  
    }  
      
    public void run(){  
        try {  
            OutputStream os = socket.getOutputStream();  
            DataOutputStream dos = new DataOutputStream(os);  
            Scanner cc = new Scanner(System.in);  
            String c = "server:"+cc.next(); 
            //Close the application when enter bye  
            while(!("server:bye".equals(c)))  
            {  
                if(socket.isClosed()==false)  
                {  
                    dos.writeUTF(c);  
                    c="server:"+cc.next();  
                }else{  
                    break;  
                }  
            }  
            dos.writeUTF(c);  
            dos.close();  
            os.close();  
            socket.close();  
        } catch (UnknownHostException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            //The exception caused by port shutdown is not handled  
        }catch(Exception e){  
            System.out.println("chat stop");  
        }  
    }  
}  