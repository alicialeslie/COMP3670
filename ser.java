package demo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ser {

	//Accept client input, process it, return it back to the client
	public static void main (String args[]) throws IOException 
	{
		//Create server socket, specifying the same port number used with the client
		ServerSocket s1 = new ServerSocket(1000);
		
		//Simple socket to accept incoming requests
		Socket ss=s1.accept();
		
		//Accept the entered number from the client, store it in number var
		Scanner sc=new Scanner(ss.getInputStream());
		int number=sc.nextInt();
		
		//Manipulate data
		int temp=number*2;
		
		//Pass data back to client
		PrintStream p= new PrintStream(ss.getOutputStream());
		
		//Send temp to client
		p.println(temp);		
	}
	
}
