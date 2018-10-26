package nio_p;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMain {
	// TODO 메인 클래스

	public static void main(String[] args) throws IOException {
		// TODO 메인 메소드

		Path pp = Paths.get("ppp");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp)); // 너 디렉토리냐?	예아~
		System.out.println(Files.isRegularFile(pp)); // 너 파일이냐? 	놉~
		System.out.println(Files.newDirectoryStream(pp));
		System.out.println();
		
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		for (Path path : ds) {
			System.out.print(Files.getLastModifiedTime(path) + "\t" + Files.size(path) + "\t");
			System.out.println(path.getFileName());
		}	//안에 있는 파일 가져온다
		
		System.out.println("==========================================");
		
		pp = Paths.get("ppp/roka.png");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.getLastModifiedTime(pp));
		System.out.println(Files.size(pp));	// 사이즈 어케되니?
		System.out.println(Files.getOwner(pp));	//파일 주인 누구니?
		System.out.println(Files.isHidden(pp));	//너 숨겨진 파일이니?
		System.out.println(Files.isReadable(pp));	//너 읽기전용? 이니?
		System.out.println(Files.isWritable(pp)); //너 수정 가능하니?
		System.out.println("파일 명 : " + pp.getFileName()); // 파일명을 알려줌
		System.out.println("현재 디렉토리 명 : " + pp.getParent().getFileName()); //느그 아버지 뭐하시노??
		System.out.println("디렉토리 경로 수 : " + pp.getNameCount()); // 몇단계를 거쳐서 이 파일 있냐
		System.out.println();
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i));
		}
		
		
	}

}
