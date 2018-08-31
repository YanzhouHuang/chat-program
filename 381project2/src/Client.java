

	import java.io.DataOutputStream;  
	import java.io.IOException;  
	import java.io.OutputStream;  
	import java.net.Socket;  
	import java.net.UnknownHostException;  
	import java.util.Scanner;  
	//Only used to send threads to the client
	public class Client extends Thread{  
	      
	    public Socket client;  
	      
	    public Client(){  
	        super();  
	    }  
	      
	    public Client(Socket client){  
	        this.client=client;  
	    }  
	      
	    public void run(){  
	        try {  
	            //Get the client output stream  
	            OutputStream os = client.getOutputStream();  
	            DataOutputStream dos = new DataOutputStream(os);  
	            //Get console information 
	            Scanner cc = new Scanner(System.in);  
	            String c = "client:"+cc.next();  
	            //Close the application when enter bye 
	            while(!("client:bye".equals(c)))  
	            {  
	                if(client.isClosed()==false)  
	                {  
	                    dos.writeUTF(c);  
	                    c="client:"+cc.next();  
	                }else{  
	                    break;  
	                }  
	            }  
	            //Send the last message, than close
	            //After closing the port, the thread used for listening will be reported exception, we can catch the exception
	            dos.writeUTF(c);  
	            dos.flush();  
	            dos.close();  
	            os.close();  
	            client.close();  
	        } catch (UnknownHostException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            //The exception caused by port shutdown is not handled  
	        }catch(Exception e){  
	            System.out.println("Chat stop");  
	        }  
	    }  
	}  

