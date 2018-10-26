package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class A_1024_FileServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			System.out.println("서버 대기");
			
			SocketChannel client = server.accept();
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			Path path = Paths.get("ppp/ccc.txt");
			
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.READ);
			
			fc.read(buf);
			
			buf.flip();
			client.write(buf);
			
			fc.close();
			client.close();
			server.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
