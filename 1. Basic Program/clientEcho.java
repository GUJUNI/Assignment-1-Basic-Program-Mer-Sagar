/*Program of Echo Sever

Client Side
*/
import java.io.*;
import java.util.*;
import java.net.*;

class clientEcho
{
        public static void main(String args[])throws Exception
        {
                
                
                try
                {
                        String server = args[0];
                        int port = Integer.parseInt(args[1]);
                        Socket s = new Socket(server,port);
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                        String str=null;
                        int i=0;
                        OutputStream os = s.getOutputStream();
                        DataOutputStream dos = new DataOutputStream(os);

                        System.out.println("Enter the Message for Server ::");
                        for(i=0;i<50;i++)
                        {
                                str = br.readLine();
                                dos.writeUTF(str);
                                if(str.equals("stop")) break;

                                
                        }

                        System.out.println("Message goes for Server");
                        System.out.println(i);                        
                }catch(Exception e)
                {
                }
        }
}

/*OUTPUT

java clientdemo 127.0.0.1 4001

Enter the Message for Server ::
good Morning
This is NICM Campus
Hello

Server Side OutPut

The Message from Client is ::good Morning
The Message from Client is ::This is NICM Campus
The Message from Client is ::Hello

*/