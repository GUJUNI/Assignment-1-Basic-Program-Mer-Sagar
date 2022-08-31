import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
        public static void main(String []args)
        {
                try
                {
                        ServerSocket serversocket;
                        Socket socket;
                        serversocket = new ServerSocket(1200);
                        while(true)
                        {
                                socket =serversocket.accept();
                                new StartThread(socket).start();
                                /*
                                StartThread st= new StartThread(socket);
                                st.start();
                                */
                        }
                }
                catch(Exception e)
                {
                        System.out.println("Exception Caught in Main");
                }
        }
}
class StartThread extends Thread
{

        Socket csocket;
        String s,r;
        Date d;
        DataInputStream in;
        DataOutputStream out;
        public StartThread(Socket s)
        {
                try
                {
                        csocket=s;
                        d=new Date();
                        in = new DataInputStream(csocket.getInputStream());
                        out = new DataOutputStream(csocket.getOutputStream());
                }
                catch(Exception e)
                {
                        System.out.println("Exception Caught in Constructor");                        
                }
        }

        public void run()
        {
             try
             {

                     r=in.readUTF();
                     System.out.println("String: " + r);
                     s=d.toString();
                     out.writeUTF(s);
                     csocket.close();
             }
             catch(Exception e)
             {
                   System.out.println("Exception Caught in Run");
             }

             
        }
}               
