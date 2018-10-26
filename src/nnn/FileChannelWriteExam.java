package nnn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteExam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Path path = Paths.get("C:/Temp/file.txt");
		Files.createDirectories(path.getParent()); //Temp 라는 폴더가 없을경우 생성 /예외처리
		
														//파일이 없으면 생성해라 ///////, 파일의 데이터를 저장해야되니깐 WRITE 옵션
		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		String data = "하이루";
		Charset charset = Charset.defaultCharset(); // 차셋을 얻어낸다, 디폴트차셋 = 운영체제가 사용하는 기본 문자셋을 사용하겠다.
		
		ByteBuffer byteBuffer = charset.encode(data); //문자열로 부터 바이트버퍼를 얻었다.
		
		//fileChannel.write(byteBuffer);
		int byteCount = fileChannel.write(byteBuffer);
		
		System.out.println("file.txt : " + byteCount + " bytes written"); // byteCount정도의 byte가 쓰여졌다.
									//하이루 라서 6바이트 썼음.
		fileChannel.close();
		//System.out.println(byteBuffer.putInt(96));
		Path path2 = Paths.get("ppp/sample.jpg");
		System.out.println(Files.size(path2));
		System.out.println(byteCount);
		//System.out.println(byteBuffer.putInt());
		
	}

}
