package com.hemalatha.jcg.download.factory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class IO7Download implements FileDownload {
	@Override
	public boolean download(String url, String outputFileName) {
		try(InputStream in = new URL(url).openStream()){
			Files.copy(in, Paths.get(outputFileName), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
