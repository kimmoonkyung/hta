package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"), 
				StandardOpenOption.CREATE, 
				StandardOpenOption.WRITE); //APPEND는 수정 같은 개념 뒤에다 붙여 씀.
		
		//버퍼생성
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("다 꺼져라 나는 역주행");
		
		//파일에 쓰기
		int cnt = channel.write(buf);
		System.out.println(cnt);
		
		buf = charset.encode("하일! 정태균");
		cnt = channel.write(buf);
		System.out.println(cnt);
		
		cnt = channel.write(buf); // 한번 작성한 buffer의 내용은 다시 사용 못함.
		System.out.println(cnt);
		
		//파일채널 닫기
		channel.close();
		
		
		
		
	}

}
