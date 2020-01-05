package com.hemalatha.jcg.download.factory;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ApacheDownload implements FileDownload {
	@Override
	public boolean download(String url, String outputFileName) {
		int CONNECTION_TIMEOUT = 10000;
		int READ_TIMEOUT = 10000;
		try {
			FileUtils.copyURLToFile(new URL(url),new File(outputFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
}
