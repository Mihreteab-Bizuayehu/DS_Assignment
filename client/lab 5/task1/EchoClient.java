import java.io.*;
import java.net.*;
public class EchoClient
{
PrintStream out=null;
BufferedReader in=null;
BufferedReader br=null;
String str="";
public EchoClient()throws IOException
{
Socket s=new Socket("localhost",7000);
out = new PrintStream(s.getOutputStream());
in = new BufferedReader(new InputStreamReader(s.getInputStream()));
br = new BufferedReader(new InputStreamReader(System.in));
while(s!=null)
{
System.out.println("Select the operation to be performed");
System.out.println("1. To send message without any response");
System.out.println("2. To send message with response");
System.out.println("3. To recieve message");
System.out.println("4. To end the program");
str=br.readLine();
out.println(str);
if(str.equals("1"))
{
MPI_send();
}
else if(str.equals("2"))
{
MPI_sendrec();
}
else if(str.equals("3"))
{
MPI_recv();
}
else
break;
} }
public static void main(String args[])throws IOException
{
    EchoClient ec = new EchoClient();
System.out.println("Exiting...");
}
void MPI_send() throws IOException
{
System.out.println("Enter Data ");
str=br.readLine();
out.println(str);
}
void MPI_sendrec() throws IOException
{
System.out.println("Enter Data ");
str=br.readLine();
out.println(str);
System.out.println(in.readLine());
}
void MPI_recv() throws IOException
{
System.out.println(in.readLine());
}