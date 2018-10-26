package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"),
				StandardOpenOption.READ
				);
				
		//가지고 올 데이터 크기를 모르므로 충분한 buffer 크기 확보
		ByteBuffer buf = ByteBuffer.allocate(40);
		Charset charset = Charset.defaultCharset();
		
		int cnt = 0;
		String data="";
		while(true) {
			cnt = channel.read(buf);
			
			if(cnt==-1)	// ******-1 이 리턴 되면 channel에서 가져올 data가 마지막이라는 것
				break;
			
			buf.flip(); //**** 검색ㄱㄱ
			
			data+=charset.decode(buf);
		
			buf.clear(); // 다쓴 버퍼는 공간을 지운다
		}
		
		
		channel.close();
	
		System.out.println(data + " @@");
	}

}
