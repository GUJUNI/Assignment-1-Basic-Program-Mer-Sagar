===========================================================
NAME      : Mer Sagar B.
ROLL NO   : 21
CLASS     : MCA 2
SUBJECT   : ADVANCED NETWORKING

===========================================================
1. WAP to implement TCP socket.(Client side)
===========================================================
import java.io.*;  
import java.net.*;  

public class TcpMyClient 
{  
    public static void main(String[] args) 
    {  
        try
        {      
            Socket s=new Socket("localhost",6666);  
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
            dout.writeUTF("Hello Server");  
            dout.flush();  
            dout.close();  
            s.close();  
        }
        catch(Exception e){System.out.println(e);}  
    }  
} 