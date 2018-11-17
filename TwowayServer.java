import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TwowayServer {
	public static void main(String[] args) {
		try {
			System.out.println("S: Server is started");
			ServerSocket ssoc = new ServerSocket(6666);
			System.out.println("S: Server is waiting for client request");
			Socket soc = ssoc.accept(); // establishing the connection
			System.out.println("S: Client is connected");
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			String str = (String) ois.readUTF();
			System.out.println("S: Client message: " + str);
			
			String newStr = "Hello Client";
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			oos.writeUTF(newStr);
			oos.flush();
			ssoc.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
