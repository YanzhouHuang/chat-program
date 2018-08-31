import java.io.DataInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.net.Socket;  
//Only used to receive threads to the client
public class ClientReceive extends Thread{  
      
    public Socket client;  
      
    public ClientReceive(){  
        super();  
    }  
      
    public ClientReceive(Socket client){  
        this.client=client;  
    }  
      
    public void run(){  
        try {  
            InputStream i = client.getInputStream();  
            DataInputStream is =new DataInputStream(i);  
            String s;  
            s = is.readUTF(); 
            //Close the application when enter bye  
            while(!("server:bye".equals(s))){  
                if(client.isClosed()==false)  
                {  
                    System.out.println(s);  
                    s=is.readUTF();  
                }else{  
                    break;  
                }  
            }  
            System.out.println(s);  
            System.out.println();  
            is.close();  
            i.close();  
            client.close();  
        } catch (IOException e) {  
            //The exception caused by port shutdown is not handled  
        }catch(Exception e){  
            System.out.println("chat stop");  
        }  
    }  
}  