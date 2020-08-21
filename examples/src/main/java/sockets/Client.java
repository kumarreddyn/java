package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("127.0.0.1", 5050);
			System.out.println("Connected to Server!!");
			//dis = new DataInputStream(System.in);
			dos = new DataOutputStream(socket.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

		String data = "";
		while (!data.equals("Exit")) {
			try {
				data = sc.next();
				dos.writeUTF(data);
			} catch (IOException i) {
				System.out.println(i);
			}
		}
		
		try {
			dos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
