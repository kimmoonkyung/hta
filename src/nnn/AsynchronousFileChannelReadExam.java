package nnn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousFileChannelReadExam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//������Ǯ ����
		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		for (int i = 0; i < 10; i++) {
			Path path = Paths.get("src/nnntest/file" + i + ".txt");
			
			//�񵿱� ���� ä�� ����
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, EnumSet.of(StandardOpenOption.READ),
					executorService);
			
			ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size()); // �� ������� ��Ÿ���� �����ϱ� ������ ��Ʈ�� ����ȯ
			
			//÷�� ��ü ����
			class Attachment {
				Path path;
				AsynchronousFileChannel fileChannel;
				ByteBuffer byteBuffer;
			}
			
			Attachment attachment = new Attachment();
			attachment.path = path;
			attachment.fileChannel = fileChannel;
			attachment.byteBuffer = byteBuffer;
			
			//CompletionHandler ��ü ����
			CompletionHandler<Integer, Attachment> completionHandler = 
					new CompletionHandler<Integer, Attachment>() {

						@Override
						public void completed(Integer result, Attachment attachment) {
							//�����尡 ���������� �۾��� �Ϸ��ѵ� �ݹ� �Ǵ� �޼ҵ�
							attachment.byteBuffer.flip();
							
							Charset charset = Charset.defaultCharset();
							String data = charset.decode(attachment.byteBuffer).toString();
							
							System.out.println(path.getFileName() + " : " + data + " : " + Thread.currentThread().getName());
							try {
								fileChannel.close();
							} catch (IOException e) {}
						}

						@Override
						public void failed(Throwable exc, Attachment attachment) {
							//�����尡 �۾��ϴ� ���߿� ���ܰ� �߻��Ǿ����� �ݹ� �Ǵ� �޼ҵ�
							exc.printStackTrace();
							try {
								fileChannel.close();
							} catch (IOException e) {System.out.println("����");}
						}
						
					};
					//���� �б�
					fileChannel.read(byteBuffer, 0, attachment, completionHandler);
		}
		//������Ǯ ����
		executorService.shutdown();
		
	}

}
