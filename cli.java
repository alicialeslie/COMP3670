package demo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner; //editing

public class cli {

	public static void main(String args[]) throws UnknownHostException, IOException
	{
		//Hold number entered by user
		int number;
		
		//Accept input from user
		Scanner sc= new Scanner(System.in);
		
		//Use simple socket for client (IP address, port #)
		//We use local address in this case, but it could be any other machines
		Socket s = new Socket("127.0.0.1",1000);
		
		//Get input stream (output from server)
		Scanner sc1 = new Scanner(s.getInputStream());
		
		//Accept num from user
		System.out.println("Enter any number");
		number=sc.nextInt();
		
		//Pass num client entered to server
		PrintStream p= new PrintStream(s.getOutputStream());
		
		//Pass number to socket
		p.println(number);
		
		//Accept result from server
		int temp=sc1.nextInt();
		System.out.println(temp);
		
	}
	
}
