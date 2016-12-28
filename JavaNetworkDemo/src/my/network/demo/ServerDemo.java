package my.network.demo;

import java.io.*;
import java.net.*;


class ServerOneThread extends Thread {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	ServerOneThread(Socket s) {
		this.socket = s;
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
			while (true) {
				String str = in.readLine();
				if (str != null) {
					if (str.toUpperCase().equals("END")) {
						break;
					}
					System.out.println("Echo: " + str);
					out.println(str);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


public class ServerDemo  {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket s = new ServerSocket(8080);
		System.out.println("Server Start.");
		try {
			while (true) {
			Socket socket = s.accept();
			try {
				new ServerOneThread(socket).start();
			} catch(Exception e) {
				socket.close();
			} finally {
				//
			}
			}
		} finally {
			s.close();
		}
	}

}
