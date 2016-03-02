package APLab3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	static ArrayList<Data> list = new ArrayList<Data>();
	
	public static void main(String[] args)
	{
		ServerSocket listener = null;
		try{
			listener = new ServerSocket(8000);
			System.out.println("Server started at port 80000");
			while(true)
			{
				Socket socket = listener.accept();
				ObjectOutputStream  OutClient = new ObjectOutputStream (socket.getOutputStream());
				ObjectInputStream inClient = new ObjectInputStream(socket.getInputStream());
				Data notes;
				notes = (Data)inClient.readObject();

				switch(notes.choice){
				case 1:
					list.add(notes);
					System.out.println("Data Received: ");
					System.out.println("User: " + notes.userName);
					System.out.println("Notes: " + notes.note);
					break;
				default:
					boolean found = false;
					for(int i = 0; i < list.size();i++)
					{
						if(list.get(i).userName.equals(notes.userName))
						{	
							found = true;
							OutClient.writeObject(list.get(i));
						}	
					}
					if(!found) {
						System.out.println("user not found!");
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}