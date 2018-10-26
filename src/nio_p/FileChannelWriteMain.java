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
				StandardOpenOption.WRITE); //APPEND�� ���� ���� ���� �ڿ��� �ٿ� ��.
		
		//���ۻ���
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("�� ������ ���� ������");
		
		//���Ͽ� ����
		int cnt = channel.write(buf);
		System.out.println(cnt);
		
		buf = charset.encode("����! ���±�");
		cnt = channel.write(buf);
		System.out.println(cnt);
		
		cnt = channel.write(buf); // �ѹ� �ۼ��� buffer�� ������ �ٽ� ��� ����.
		System.out.println(cnt);
		
		//����ä�� �ݱ�
		channel.close();
		
		
		
		
	}

}