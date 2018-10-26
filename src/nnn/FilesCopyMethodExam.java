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
		
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING); //�����Ѵٸ� ��ü���ض�
		
		System.out.println("copyMethod ���� ���� ����");
		
		//�ܼ��� ���ϸ� �����ϴ°��̶�� ī�Ǹ޼ҵ带 ����ϴ°��� �ڵ尡 ����������
		
	}

}
