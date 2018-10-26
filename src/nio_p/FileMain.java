package nio_p;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMain {
	// TODO ���� Ŭ����

	public static void main(String[] args) throws IOException {
		// TODO ���� �޼ҵ�

		Path pp = Paths.get("ppp");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp)); // �� ���丮��?	����~
		System.out.println(Files.isRegularFile(pp)); // �� �����̳�? 	��~
		System.out.println(Files.newDirectoryStream(pp));
		System.out.println();
		
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		for (Path path : ds) {
			System.out.print(Files.getLastModifiedTime(path) + "\t" + Files.size(path) + "\t");
			System.out.println(path.getFileName());
		}	//�ȿ� �ִ� ���� �����´�
		
		System.out.println("==========================================");
		
		pp = Paths.get("ppp/roka.png");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.getLastModifiedTime(pp));
		System.out.println(Files.size(pp));	// ������ ���ɵǴ�?
		System.out.println(Files.getOwner(pp));	//���� ���� ������?
		System.out.println(Files.isHidden(pp));	//�� ������ �����̴�?
		System.out.println(Files.isReadable(pp));	//�� �б�����? �̴�?
		System.out.println(Files.isWritable(pp)); //�� ���� �����ϴ�?
		System.out.println("���� �� : " + pp.getFileName()); // ���ϸ��� �˷���
		System.out.println("���� ���丮 �� : " + pp.getParent().getFileName()); //���� �ƹ��� ���Ͻó�??
		System.out.println("���丮 ��� �� : " + pp.getNameCount()); // ��ܰ踦 ���ļ� �� ���� �ֳ�
		System.out.println();
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i));
		}
		
		
	}

}
