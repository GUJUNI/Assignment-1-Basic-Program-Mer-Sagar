import java.io.*;
import java.util.*;
import java.net.*;

public class DnsClient
{
        public static void main(String []args)
        {
                String sname,ipadd;                                                     
                byte[] datas=new byte[25];
                byte[] datar=new byte[25];
                DatagramPacket ps,pr;
                DatagramSocket s;
                DataInputStream r;
                try
                {
                        InetAddress add=InetAddress.getLocalHost();
                        r=new DataInputStream(System.in);
                        System.out.println("Enter Server Name: ");
                        sname=r.readLine();
                        if(r!=null)
                        {               
                                datas=sname.getBytes();
                                s=new DatagramSocket();
                                ps=new DatagramPacket(datas,datas.length,add,3000);
                                s.send(ps);

                                pr=new DatagramPacket(datar,datar.length);
                                s.receive(pr);
                                ipadd=new String(datar,0,datar.length);
                                System.out.println("Ip Address of "  + sname + ": " + ipadd);
                         }
                }
                catch(Exception e)
                {
                        System.out.println("Exception in Client");       
                }

                
        }
}
