package APLab3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1 to add new record, 2 to search record");

		int operation = Integer.parseInt(input.nextLine());
		System.out.println("Type username: ");
		String username = input.nextLine();
		Data notes;
		
		switch(operation){
		case 1:
			
			System.out.println("Type the notes: ");
			String note = input.nextLine();
			notes = new Data(username,note,1);
			break;
		default:
			notes = new Data(username,"",2);
			
		}
		input.close();
		try
		{	
			Socket sender = new Socket("localhost",8000);
			
			ObjectOutputStream outServer = new ObjectOutputStream(sender.getOutputStream());
			ObjectInputStream inServer = new ObjectInputStream(sender.getInputStream());
			
			outServer.writeObject(notes);

			if(notes.choice == 2)
			{
				while(true)
				{
					Data notes1 = (Data)inServer.readObject();
					System.out.println("User Found: ");
					System.out.println("User Name: "+notes1.userName);
					System.out.println("Notes : "+ notes1.note);
				}
			}

			sender.close();   
		}
		catch(Exception e)
		{
			System.out.println("Exception");
			System.out.println(e.getMessage());
		}
	}




}

