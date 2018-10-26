package nnn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousFileChannelWriteExam {

	
	/*
	 * FileChannel�� ����
	 * read() �� write() �޼ҵ�� ���ŷ�̵ȴ�
	 * - ���ŷ ���ȿ� ui �����̳� �̺�Ʈ ó���� �� �� ����.
	 * - ���� ������ �۾� �����带 �����ؼ� �̵� �޼ҵ带 ȣ���ؾ��Ѵ�.
	 * - ���ÿ� ó���ؾ��� ������ ���� ���ٸ� ������ �� ������ ������ �� �� �ֵ�.
	 * 
	 * AsynchronousFileChannel
	 * read()�� write() �޼ҵ�� ��� ���ϵȴ�.
	 * - �̵� �޼ҵ�� ������Ǯ���� �۾� ó���� ��û�ϰ� ��� ���ϵȴ�.
	 * - �۾� �����尡 ���� ������� �Ϸ��ϰ� �Ǹ� �ݹ� �޼ҵ尡 �ڵ� ȣ�� �ȴ�.
	 * - ��Ư�� �ټ��� ���� �� ��뷮 ������ ����� �۾��� �����ϴ�.
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//������Ǯ ����
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		for (int i = 0; i < 10; i++) {
			Path path = Paths.get("src/nnntest/file" + i +  ".txt");
			Files.createDirectories(path.getParent()); // ������ ������ �����ض�
			
			//�񵿱� ���� ä�� ����
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
					path, 
					EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE),
					executorService
			);
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer byteBuffer = charset.encode("�氡���̷�");
			
			//÷�� ��ü ����
			class Attachment {
				Path path;
				AsynchronousFileChannel fileChannel;
				//�̷� �ϴ�����
				/*
				 * ������ 10�� ���鼭 ��� �н� ��ü ����,(�񵿱� ���� ä�� ��ü ����)
				 * �̰͵��� ÷�� ��ü�� ��Ƽ�
				 * �ݹ� �޼ҵ忡 �Ѱ��ָ�
				 * ���߿� �ݹ�޼ҵ尡 �۾��� �Ϸ�Ǿ� ȣ��ɶ�
				 * �� �������� Ȱ���Ͽ� �ٸ� �۾����� �� �� �ֵ�.
				 */
			}
			
			Attachment attachment = new Attachment();
			attachment.path = path;
			attachment.fileChannel = fileChannel;
			
			//CompletionHandler ��ü ����
			CompletionHandler<Integer, Attachment> completionHandler = 
					new CompletionHandler<Integer, Attachment>() {

						@Override
						public void completed(Integer result, Attachment attachment) {
							// TODO ���ø�Ʈ
							//�����尡 ���������� �۾��� �Ϸ��ѵ� �ݹ� �Ǵ� �޼ҵ�
							System.out.println(attachment.path.getFileName() + " : " + result + " bytes written : " + Thread.currentThread().getName());
							try {
								attachment.fileChannel.close();
							} catch (IOException e) {}
						}

						@Override
						public void failed(Throwable exc, Attachment attachment) {
							// TODO ���ϵ�
							//�����尡 �۾��ϴ� ���߿� ���ܰ� �߻��Ǿ����� �ݹ� �Ǵ� �޼ҵ�
							exc.printStackTrace();
							try {
								attachment.fileChannel.close();
							} catch (IOException e) {}
						}
				
					};
							// ��� ���ϵǴ� write
					fileChannel.write(byteBuffer, 0, attachment, completionHandler);
			
		}
		
		//������ Ǯ ����
		executorService.shutdown();
		
		
	}

}
