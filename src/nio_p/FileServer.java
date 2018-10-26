package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			System.out.println("서버 대기");
			
			Path path = Paths.get("ppp/sikppang.jpg");
			System.out.println(Files.size(path));
			SocketChannel client = server.accept(); //서버로 접근시도한 소켓을 받는거. (소켓채널을 client에 저장)
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			int size = (int)Math.ceil((double)Files.size(path)/buf.capacity());
			
			buf.putInt(size);
			buf.flip();
			
			client.write(buf);
			buf.clear();
			
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.READ);
			
			for (int i = 0; i < size; i++) {
				int cnt =fc.read(buf);
				
				buf.flip();
				client.write(buf);
				buf.clear();
				
				System.out.println("server:"+cnt);
			}
			
			
			
			
			fc.close();
			client.close();
			server.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
