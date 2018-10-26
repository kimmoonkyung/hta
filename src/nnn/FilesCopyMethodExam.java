package nnn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class FilesCopyMethodExam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path from = Paths.get("src/nnn/roka.png");
		Path to = Paths.get("src/nnn/roka2.png");
		
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING); //존재한다면 대체를해라
		
		System.out.println("copyMethod 파일 복사 성공");
		
		//단순히 파일만 복사하는것이라면 카피메소드를 사용하는것이 코드가 간결해진다
		
	}

}
