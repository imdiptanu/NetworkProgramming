import java.io.ObjectOutputStream;
import java.net.Socket;

public class OnewayClient {
	public static void main(String[] args) {
		try {
			Socket soc = new Socket("localhost", 6666);
			ObjectOutputStream out = new ObjectOutputStream(
					soc.getOutputStream());
			out.writeUTF("Hello Server");
			out.flush();
			out.close();
			soc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
