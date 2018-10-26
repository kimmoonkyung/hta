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
		//스레드풀 생성
		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		for (int i = 0; i < 10; i++) {
			Path path = Paths.get("src/nnntest/file" + i + ".txt");
			
			//비동기 파일 채널 생성
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, EnumSet.of(StandardOpenOption.READ),
					executorService);
			
			ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size()); // 이 사이즈는 롱타입을 리턴하기 떄문에 인트로 형변환
			
			//첨부 객체 생성
			class Attachment {
				Path path;
				AsynchronousFileChannel fileChannel;
				ByteBuffer byteBuffer;
			}
			
			Attachment attachment = new Attachment();
			attachment.path = path;
			attachment.fileChannel = fileChannel;
			attachment.byteBuffer = byteBuffer;
			
			//CompletionHandler 객체 생성
			CompletionHandler<Integer, Attachment> completionHandler = 
					new CompletionHandler<Integer, Attachment>() {

						@Override
						public void completed(Integer result, Attachment attachment) {
							//쓰레드가 성공적으로 작업을 완료한뒤 콜백 되는 메소드
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
							//쓰레드가 작업하는 도중에 예외가 발생되었을때 콜백 되는 메소드
							exc.printStackTrace();
							try {
								fileChannel.close();
							} catch (IOException e) {System.out.println("예외");}
						}
						
					};
					//파일 읽기
					fileChannel.read(byteBuffer, 0, attachment, completionHandler);
		}
		//스레드풀 종료
		executorService.shutdown();
		
	}

}
