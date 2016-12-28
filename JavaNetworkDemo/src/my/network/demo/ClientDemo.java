package my.network.demo;
import java.io.*;
import java.net.*;

public class ClientDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InetAddress addr = InetAddress.getByName(null);
		Socket socket = new Socket(addr, 8080);
		try {
			BufferedReader reader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			for (int i = 0; i < 10; ++i) {
				out.println("Client" + ((int)(Math.random() * 100) +1));
				System.out.println(reader.readLine());
			}
//			out.println("end");
			
		} finally {
			System.out.println("Client Closed");
			socket.close();
		}
	}

}
