import java.io.*;
import java.net.*;

public class Client
{
        public static void main(String []args)
        {
                try
                {
                        String send,receive;
                        InetAddress add=InetAddress.getLocalHost();
                        Socket s=new Socket(add,1200);
                        DataInputStream r = new DataInputStream(System.in);
                        DataInputStream in=new DataInputStream(s.getInputStream());
                        DataOutputStream out =new DataOutputStream(s.getOutputStream());
   			System.out.println("Date and Time");
                        System.out.println("Enter Your Name: ");
                        send=r.readLine();                 
                        out.writeUTF(send);
                        receive=in.readUTF();
                        System.out.println("Receive: " + receive);
                        s.close();
                 }
                catch(Exception e)
                {
                    System.out.println("Exception Caught");
                }

        }
}
