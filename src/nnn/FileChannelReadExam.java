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
		
		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ); // ����ó��
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		
		Charset charset = Charset.defaultCharset();
		String data = "";
		
		int byteCount;
		
		while(true) {
			byteCount = fileChannel.read(byteBuffer); //���� ����Ʈ ���� ������ ����
			if(byteCount == -1) break; 
			// ������ ���� �аԵǸ� ����� -1�� �����ϱ� ������, ���̻� ���� ���� ���⶧���� ���ѷ��� Ż��
			byteBuffer.flip(); //read�� �ϸ� �ø��� �ݵ�� �� �ٴð���
			data += charset.decode(byteBuffer).toString(); // �����Ǻ��� ���Ա���, �� ���۸� �������
			
			byteBuffer.clear(); //Ŭ���� �޼ҵ�� �������� 0���� ������ capacity�� �̵��ϰԲ� �������
			//Ŭ���� �ϴ� ������ �ٽ� ���Ϲ� ó������ ���� ������ ����޼ҵ尡 0 �ε�������
			//����Ʈ ���ۿ� �����͸� ������ �� �ְ��ϱ� ����
		}
		
		fileChannel.close();
		
		System.out.println("file.txt : " + data);
	}

}
