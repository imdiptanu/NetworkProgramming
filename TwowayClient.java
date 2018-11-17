import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TwowayClient {
	public static void main(String[] args) {
		try {
			Socket soc = new Socket("localhost", 6666);
			ObjectOutputStream out = new ObjectOutputStream(
					soc.getOutputStream());
			out.writeUTF("C: Hello Server");
			out.flush();
			
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			String str = (String) ois.readUTF();
			System.out.println("C: Server message: " + str);
			
			out.close();
			soc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
