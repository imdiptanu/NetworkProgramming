import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OnewayServer {
	public static void main(String[] args) {
		try {
			System.out.println("Server is started");
			ServerSocket ssoc = new ServerSocket(6666);
			System.out.println("Server is waiting for client request");
			Socket soc = ssoc.accept(); // establishing the connection
			System.out.println("Client is connected");
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			String str = (String) ois.readUTF();
			System.out.println("Client message: " + str);
			ssoc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
