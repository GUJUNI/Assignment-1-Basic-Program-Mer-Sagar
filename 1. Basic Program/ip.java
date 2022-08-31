import java.net.*;
class Ip
{
        public static void main(String args[]){
                try{
                        InetAddress ia=InetAddress.getLocalHost();
                        String s=ia.toString();
                        System.out.println("IA " + ia);
                        System.out.println("S " + s);
                }
                catch(Exception e){
                        System.out.println(e);
                }
        }
}
