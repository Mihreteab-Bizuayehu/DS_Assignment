import java.io.*;
import java.net.*;
public class EchoServer implements Runnable
{
Socket socket=null;
static ServerSocket ss;
EchoServer(Socket newSocket)
{
this.socket=newSocket;
}
public static void main(String args[]) throws IOException
{
ss=new ServerSocket(7000);
System.out.println("Server Started");
while(true)
{
    Socket s = ss.accept();
EchoServer es = new EchoServer(s);
Thread t = new Thread(es);
t.start();
} }
public void run()
{
try {
while(ss!=null)
{
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream() ));
PrintStream out = new PrintStream(socket.getOutputStream());
BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
String str=in.readLine();
if(str.equals("1"))
{
System.out.println(in.readLine());
}
else if(str.equals("2"))
{
System.out.println(in.readLine());
System.out.println("Enter Data ");
str=br.readLine();
out.println(str);
}
else if(str.equals("3"))
{
System.out.println("Enter Data ");
str=br.readLine();
out.println(str);
} }
System.out.println("Exiting...");
}
catch(Exception e)
{}
} }
