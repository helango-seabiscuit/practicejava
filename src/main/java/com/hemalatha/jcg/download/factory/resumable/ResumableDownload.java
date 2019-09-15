package com.hemalatha.jcg.download.factory.resumable;

import com.hemalatha.jcg.download.factory.FileDownload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResumableDownload implements FileDownload {


	@Override
	public boolean download(String url,String outputFileName) {
		File outputFile = new File(outputFileName);
		Path file = Paths.get(outputFileName);
		try {

            long removeFileSize = sizeOfFileToBeDownloaded(url);
			URL fileUrl = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection)fileUrl.openConnection();
			long existingFileLength = outputFile.length();
			if( existingFileLength < removeFileSize){
				httpURLConnection.setRequestProperty("Range","bytes="+existingFileLength+"-"+removeFileSize);


			long bytesDownloaded = 0;
			try(InputStream is = httpURLConnection.getInputStream(); OutputStream os = new FileOutputStream(outputFile,true)){
				byte[] buffer = new byte[1024];
				int bytesCount;
				while ((bytesCount = is.read(buffer)) > 0){
					os.write(buffer,0,bytesCount);
					bytesDownloaded += bytesCount;
				}
			}
			}else{
				System.out.println("Already Donwloaded");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return true;
	}

	public long sizeOfFileToBeDownloaded(String url) throws Exception{
		URL fileUrl = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection)fileUrl.openConnection();
		httpURLConnection.setRequestMethod("HEAD");
		long removeFileSize = httpURLConnection.getContentLengthLong();
		System.out.println("Size of file to be downloaded = "+removeFileSize);
		httpURLConnection.disconnect();
		return removeFileSize;
	}
}
