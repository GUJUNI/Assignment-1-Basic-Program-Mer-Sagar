/*Program of Echo Sever

Server Side
*/

import java.io.*;
import java.net.*;
import java.util.*;

class serverEcho
{
      
        public static void main(String args[])
        {
                      try
                        {
                         	  int port = Integer.parseInt(args[0]);

	                       ServerSocket ss = new ServerSocket(port);
                  	     String str;
	                       int i;
                  	    Socket s = ss.accept();
	              while(true)
                                {
                        
                                        InputStream is = s.getInputStream();
                                         DataInputStream dis = new DataInputStream(is);
                
                        
                                        str=dis.readUTF();
                                        System.out.println("The Message from Client is ::"+str);
                                       
                                }
                        }catch(Exception e)
                        {
                        }
               
	}
        
}
