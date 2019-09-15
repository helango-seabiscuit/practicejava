package com.hemalatha.jcg.download.factory;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class IODownload  implements FileDownload{
	@Override
	public boolean download(String url, String outputFileName) {

		try(BufferedInputStream in = new BufferedInputStream(new URL(url).openStream()); FileOutputStream fs = new FileOutputStream(outputFileName)){
			byte[] dataBuffer = new byte[1024];
			int bytesRead;
			while((bytesRead = in.read(dataBuffer)) > 0){
				fs.write(dataBuffer,0,bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
