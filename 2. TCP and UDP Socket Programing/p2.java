=====================================================
NAME    : Mer Sagar B.
ROLL NO : 21
CLASS   : MCA 2
SUBJECT : ADVANCED NETWORKING

=====================================================
2. WAP to implement TCP socket.(server side)
=====================================================
import java.io.*;  
import java.net.*;  

public class TcpMyServer 
{  
    public static void main(String[] args)
    {  
        try
        {  
            ServerSocket ss=new ServerSocket(6666);  
            Socket s=ss.accept();//establishes connection   
            DataInputStream dis=new DataInputStream(s.getInputStream());  
            String  str=(String)dis.readUTF();  
            System.out.println("message= "+str);  
            ss.close();  
        }
        catch(Exception e){System.out.println(e);}  
    }  
} 