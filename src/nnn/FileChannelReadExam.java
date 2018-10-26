package nnn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadExam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Path path = Paths.get("C:/Temp/file.txt");
		
		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ); // 예외처리
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		
		Charset charset = Charset.defaultCharset();
		String data = "";
		
		int byteCount;
		
		while(true) {
			byteCount = fileChannel.read(byteBuffer); //읽은 바이트 수를 변수에 저장
			if(byteCount == -1) break; 
			// 파일의 끝을 읽게되면 리드는 -1을 리턴하기 때문에, 더이상 읽을 것이 없기때문에 무한루프 탈출
			byteBuffer.flip(); //read를 하면 플립은 반드시 함 바늘과실
			data += charset.decode(byteBuffer).toString(); // 포지션부터 리밋까지, 차 버퍼를 만들어줌
			
			byteBuffer.clear(); //클리어 메소드는 포지션을 0으로 리밋을 capacity로 이동하게끔 만들어줌
			//클리어 하는 이유는 다시 와일문 처음으로 돌아 갔을때 리드메소드가 0 인덱스부터
			//바이트 버퍼에 데이터를 저장할 수 있게하기 위해
		}
		
		fileChannel.close();
		
		System.out.println("file.txt : " + data);
	}

}
