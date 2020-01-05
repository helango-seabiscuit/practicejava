package com.hemalatha.ftp;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FtpClient {

	private String server;
	private int port;
	private String user;
	private String password;
	private FTPClient ftpClient;

	public FtpClient(String localhost, int serverControlPort, String user, String password) {
		this.server = localhost;
		this.port = serverControlPort;
		this.user = user;
		this.password = password;
	}

	void open() throws IOException {
		ftpClient = new FTPClient();
		ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		ftpClient.connect(server,port);
		int reply = ftpClient.getReplyCode();
		if(!FTPReply.isPositiveCompletion(reply)){
			ftpClient.disconnect();
			throw new IOException("Exception in connecting to FTP server");
		}

		ftpClient.login(user,password);
	}

	void close() throws IOException {
		ftpClient.disconnect();
	}


	public Collection<String> listFiles(String path) throws IOException{
		FTPFile[] files = ftpClient.listFiles(path);
		return Arrays.stream(files)
				.map(FTPFile::getName)
				.collect(Collectors.toList());
	}

	public void downloadFile(String source, String destination) throws IOException{
		FileOutputStream out = new FileOutputStream(destination);
		ftpClient.retrieveFile(source,out);
	}

	public void putFileToPath(File file, String path) throws IOException{
		ftpClient.storeFile(path,new FileInputStream(file));
	}
}
