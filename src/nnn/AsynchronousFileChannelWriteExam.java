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
	 * FileChannel의 단점
	 * read() 와 write() 메소드는 블로킹이된다
	 * - 블로킹 동안에 ui 갱신이나 이벤트 처리를 할 수 없다.
	 * - 따라서 별도의 작업 스레드를 생성해서 이들 메소드를 호출해야한다.
	 * - 동시에 처리해야할 ㅈ파일 수가 많다면 스레드 수 증가로 문제가 될 수 있따.
	 * 
	 * AsynchronousFileChannel
	 * read()와 write() 메소드는 즉시 리턴된다.
	 * - 이들 메소드는 스레드풀에게 작업 처리를 요청하고 즉시 리턴된다.
	 * - 작업 스레드가 파일 입출력을 완료하게 되면 콜백 메소드가 자동 호출 된다.
	 * - 불특정 다수의 파일 및 대용량 파일의 입출력 작업시 유리하다.
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//스레드풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		for (int i = 0; i < 10; i++) {
			Path path = Paths.get("src/nnntest/file" + i +  ".txt");
			Files.createDirectories(path.getParent()); // 폴더가 없으면 생성해라
			
			//비동기 파일 채널 생성
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
					path, 
					EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE),
					executorService
			);
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer byteBuffer = charset.encode("방가하이루");
			
			//첨부 객체 생성
			class Attachment {
				Path path;
				AsynchronousFileChannel fileChannel;
				//이래 하는이유
				/*
				 * 포문이 10번 돌면서 계속 패스 객체 생성,(비동기 파일 채널 객체 생성)
				 * 이것들을 첨부 객체로 담아서
				 * 콜백 메소드에 넘겨주면
				 * 나중에 콜백메소드가 작업이 완료되어 호출될때
				 * 이 정보들을 활용하여 다른 작업들을 할 수 있따.
				 */
			}
			
			Attachment attachment = new Attachment();
			attachment.path = path;
			attachment.fileChannel = fileChannel;
			
			//CompletionHandler 객체 생성
			CompletionHandler<Integer, Attachment> completionHandler = 
					new CompletionHandler<Integer, Attachment>() {

						@Override
						public void completed(Integer result, Attachment attachment) {
							// TODO 컴플리트
							//쓰레드가 성공적으로 작업을 완료한뒤 콜백 되는 메소드
							System.out.println(attachment.path.getFileName() + " : " + result + " bytes written : " + Thread.currentThread().getName());
							try {
								attachment.fileChannel.close();
							} catch (IOException e) {}
						}

						@Override
						public void failed(Throwable exc, Attachment attachment) {
							// TODO 페일드
							//쓰레드가 작업하는 도중에 예외가 발생되었을때 콜백 되는 메소드
							exc.printStackTrace();
							try {
								attachment.fileChannel.close();
							} catch (IOException e) {}
						}
				
					};
							// 즉시 리턴되는 write
					fileChannel.write(byteBuffer, 0, attachment, completionHandler);
			
		}
		
		//스레드 풀 종료
		executorService.shutdown();
		
		
	}

}
