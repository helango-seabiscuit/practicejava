package com.hemalatha.jcg.download.factory;

import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.Response;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AsyncFileDownload implements FileDownload {
	@Override
	public boolean download(String url, String outputFileName) {
		try {
			FileOutputStream fs = new FileOutputStream(outputFileName);
			AsyncHttpClient client = Dsl.asyncHttpClient();
			client.prepareGet(url)
					.execute(new AsyncCompletionHandler<FileOutputStream>() {

						@Override
						public State onBodyPartReceived(HttpResponseBodyPart content) throws Exception {
							fs.getChannel().write(content.getBodyByteBuffer());
							return State.CONTINUE;
						}

						@Override
						public FileOutputStream onCompleted(Response response) throws Exception {
							return fs;
						}
					}).get();
			fs.getChannel().close();
			client.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
