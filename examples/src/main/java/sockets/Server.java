package sockets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;
		DataInputStream dis;
				
		try {
			serverSocket = new ServerSocket(5050);
			System.out.println("Server started and waiting for a client");
			socket = serverSocket.accept();
			System.out.println("Client connected");
			dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			String  data = "";
			while(!data.equals("Exit")){
				try{
					System.out.println("Enter data to be sent to client:");
					data = dis.readUTF();
					System.out.println("Data sent by client: "+data);
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			socket.close();
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
