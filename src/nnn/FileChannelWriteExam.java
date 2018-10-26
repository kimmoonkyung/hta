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
		Files.createDirectories(path.getParent()); //Temp ��� ������ ������� ���� /����ó��
		
														//������ ������ �����ض� ///////, ������ �����͸� �����ؾߵǴϱ� WRITE �ɼ�
		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		String data = "���̷�";
		Charset charset = Charset.defaultCharset(); // ������ ����, ����Ʈ���� = �ü���� ����ϴ� �⺻ ���ڼ��� ����ϰڴ�.
		
		ByteBuffer byteBuffer = charset.encode(data); //���ڿ��� ���� ����Ʈ���۸� �����.
		
		//fileChannel.write(byteBuffer);
		int byteCount = fileChannel.write(byteBuffer);
		
		System.out.println("file.txt : " + byteCount + " bytes written"); // byteCount������ byte�� ��������.
									//���̷� �� 6����Ʈ ����.
		fileChannel.close();
		//System.out.println(byteBuffer.putInt(96));
		Path path2 = Paths.get("ppp/sample.jpg");
		System.out.println(Files.size(path2));
		System.out.println(byteCount);
		//System.out.println(byteBuffer.putInt());
		
	}

}
