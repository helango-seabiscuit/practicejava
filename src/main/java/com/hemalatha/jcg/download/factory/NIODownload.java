package com.hemalatha.jcg.download.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class NIODownload implements FileDownload {
	@Override
	public boolean download(String url, String outputFileName) {

		try {
			URL fileUrl = new URL(url);

		try(ReadableByteChannel readableByteChannel = Channels.newChannel(fileUrl.openStream())){
			FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
			FileChannel fileChannel = fileOutputStream.getChannel();
			fileChannel.transferFrom(readableByteChannel,0,Long.MAX_VALUE);

		} catch (IOException e) {
			e.printStackTrace();
		}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
