#include<sys/type> //header file defines a collection of typedef symbols and structures
#include<unistd>  
#include<stdio>  //header file which include the input/output related functions of program
#include<string> //this header is used to declar string variables
#include<stdlib> // includes standard library which functions involving memory allocation, process control, conversions and others.
#include<signal> 
#include<sys/socket>
#include<sys/un>
#include <iostream>

using namespace std;
    #define SIM_LENGTH 10                    // number of integers to be written and read 
    #define IP_ADDRESS "10.161.165.218"      // Internet address of server 
    #define PORT 1897                        // local port on which the server establishes connection 

int main (){
int sock;          /* socket file descriptor */

struct sockaddr_in cli_name;
int count;
int value;      /* variable for number read from socket */
  cout<<"Client is alive and establishing socket connection.";
     
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0){
        perror ("Error opening channel");
         close(sock);
          exit(1);  
    }
    bzero(&cli_name, sizeof(cli_name));  // initializes the address structure 
    cli_name.sin_family = AF_INET;      // socket family will be AF_INET (Internet) 
    cli_name.sin_addr.s_addr = inet_addr(IP_ADDRESS);   // sets the Internet  Protocol (IP) address of the server 

    cli_name.sin_port = htons(PORT);   /* sets the port on which the server will
				      establish the socket connection */
    
     if (connect(sock, (struct sockaddr *)&cli_name, sizeof(cli_name)) < 0)
    { perror ("Error establishing communications");
      close(sock);
      exit(1);
    }
     for (count = 1; count <= SIM_LENGTH; count++) {
         read(sock, &value, 4); //The read() function reads data previously written to a file
      cout<<"Client has received from socket" + value;
         
           cout<<"Exit";

  close(sock);//close
  exit(0);
    }
return 0;
}
  




