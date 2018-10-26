package nnn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopyExam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path from = Paths.get("ppp/sik.jpg");
		Path to = Paths.get("src/nnn/sikCopy.jpg");
		
		FileChannel fileChannel_from = FileChannel.open(from, StandardOpenOption.READ); // 읽기만 할것이기 때문에 READ
		FileChannel fileChannel_to = FileChannel.open(to, StandardOpenOption.CREATE, StandardOpenOption.WRITE); // 복사할거니깐 크리에잍 롸잍
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100); //엘로케이트 다이렉트 , 채널을 읽고 버퍼를 생성할것 같으면 좀더 좋은 성능을 냄
		int byteCount;
		while(true) {
			buffer.clear(); //재사용할것이니 클리어 ㅁ소드 사용
			
			byteCount = fileChannel_from.read(buffer); //읽은 데이터는 버퍼에 저장
			if(byteCount == -1) break; //파일의 끝을 읽었다면 무한루프 탈출
			buffer.flip(); // 버퍼를 읽고 저장했다면 버퍼를 읽기모드로 .리밋을 포지션으로 포지션을 0으로
			fileChannel_to.write(buffer);
		
		}
		
		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("파일 복사 성공");
	}

}
