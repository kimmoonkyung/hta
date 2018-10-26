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
		
		FileChannel fileChannel_from = FileChannel.open(from, StandardOpenOption.READ); // �б⸸ �Ұ��̱� ������ READ
		FileChannel fileChannel_to = FileChannel.open(to, StandardOpenOption.CREATE, StandardOpenOption.WRITE); // �����ҰŴϱ� ũ������ �֟�
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100); //��������Ʈ ���̷�Ʈ , ä���� �а� ���۸� �����Ұ� ������ ���� ���� ������ ��
		int byteCount;
		while(true) {
			buffer.clear(); //�����Ұ��̴� Ŭ���� ���ҵ� ���
			
			byteCount = fileChannel_from.read(buffer); //���� �����ʹ� ���ۿ� ����
			if(byteCount == -1) break; //������ ���� �о��ٸ� ���ѷ��� Ż��
			buffer.flip(); // ���۸� �а� �����ߴٸ� ���۸� �б���� .������ ���������� �������� 0����
			fileChannel_to.write(buffer);
		
		}
		
		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("���� ���� ����");
	}

}
