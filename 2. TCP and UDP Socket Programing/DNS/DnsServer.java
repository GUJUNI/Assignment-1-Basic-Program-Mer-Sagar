import java.io.*;
import java.net.*;
import java.util.*;
class StartThread extends Thread
{
        DatagramSocket s;
        DatagramPacket ds,dr;
        boolean b=false;
        String sname,ipadd,read,tmp,sh;
        StringTokenizer st;
        File fl;
        FileInputStream fin;
        DataInputStream din;
        byte datas[];
        byte datar[];
        public StartThread(DatagramSocket socket,DatagramPacket packet)
        {
                try
                {
                        s=socket;
                        dr=packet;
                        datas =new byte[25];
                        datar =new byte[25];
                        fl=new File("dns.txt");
                        fin=new FileInputStream(fl);
                        din=new DataInputStream(fin);
                }
                catch(Exception e)
                {
                        System.out.println("Exception in Constructor");
                }

        }                
        public void run()
        {
                 
                try
                {
                        System.out.println(Thread.currentThread());
                        sname=new String(dr.getData());
                        sh=sname.trim();
                        System.out.println("Server Name: " + sh);
                        while((read=din.readLine())!=null)
                        {
                            st=new StringTokenizer(read,":");
                            tmp=st.nextToken();

                            b=sh.equals(tmp);

                           if (b==true)
                           {   
                                    ipadd=st.nextToken();    
                                    datas = ipadd.getBytes();
                                    ds = new DatagramPacket(datas, datas.length,dr.getAddress(),dr.getPort());
                                    s.send(ds);
                                    break;
                           }                        
                       }
                        if(b==false)
                        {
                                ipadd="No Address Found";
                                datas=ipadd.getBytes();
                                ds = new DatagramPacket(datas, datas.length,dr.getAddress(),dr.getPort());
                                s.send(ds);
                                System.out.println("No Server Found");
                        }

                }
                catch(Exception e)
                {
                        System.out.println("Exception Caught");
                }
        }
}
public class DnsServer
{
        public static void main(String []args)
        {
                DatagramPacket ds,dr;
                DatagramSocket s;
                byte datar[];           
                try
                {
                        s=new DatagramSocket(3000);
                        while(true)
                        {
                                datar = new byte[50];
                                dr=new DatagramPacket(datar,datar.length);
                                s.receive(dr);
                                new StartThread(s,dr).start();

                        }
//                        s.close();
                }
                catch(Exception e)
                {
                        System.out.println("EXception in Main" + e);
                }

        }
}

