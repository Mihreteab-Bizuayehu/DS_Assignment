import java.io.*;
import java.net.*;
class Serve
{
    public static void main(String args[]) throws Exception
    {
    ServerSocket ss=new ServerSocket(4722);
    System.out.println("Server is Started (listen mode) ....");
    Socket s1 = ss.accept();
    System.out.println("1st client connected ....");
    BufferedReader br1 = new BufferedReader(new
    InputStreamReader(s1.getInputStream()));
    PrintStream ps1 = new PrintStream(s1.getOutputStream());
    ps1.println("Hi client... connection established.. Enter commit or abort
    : ");
    ps1.flush();
    Socket s2 = ss.accept();
    System.out.println("2nd client connected ....");
    BufferedReader br2 = new BufferedReader(new
    InputStreamReader(s2.getInputStream()));
    PrintStream ps2 = new PrintStream(s2.getOutputStream());
    ps2.println("Hi client... connection established.. Enter commit or abort
    : ");
    ps2.flush();
    String str1 = br1.readLine();
    String str2 = br2.readLine();
    if(str1.equalsIgnoreCase("commit") &&
    str2.equalsIgnoreCase("commit"))
    {
    System.out.println("1st client said : " + str1 );
    System.out.println("2nd client said : " + str2 );
    System.out.println("Result : doCommit");
    ps1.println("Result : doCommit");
    ps1.flush();
    ps2.println("Result : doCommit");
    ps2.flush();
}
else
{
System.out.println("1st client said : " + str1 );
System.out.println("2nd client said : " + str2 );
System.out.println("Result : doAbort");
ps1.println("Result : doAbort");
ps1.flush();
ps2.println("Result : doAbort");
ps2.flush();
}
}
}
