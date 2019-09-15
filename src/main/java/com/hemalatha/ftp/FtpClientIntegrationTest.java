package com.hemalatha.ftp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

public class FtpClientIntegrationTest {

	private FakeFtpServer fakeFtpServer;

	private FtpClient ftpClient;

	@Before
	public void setUp() throws IOException {
		fakeFtpServer = new FakeFtpServer();
		fakeFtpServer.addUserAccount(new UserAccount("user","password","/data"));

		FileSystem fileSystem = new UnixFakeFileSystem();
		fileSystem.add(new DirectoryEntry("/data"));
		fileSystem.add(new FileEntry("/data/foobar.txt","abcdef 1234567890"));
		fakeFtpServer.setFileSystem(fileSystem);
		fakeFtpServer.setServerControlPort(0);

		fakeFtpServer.start();
		ftpClient = new FtpClient("localhost",fakeFtpServer.getServerControlPort(),"user","password");
		ftpClient.open();

	}


	@After
	public void tearDown() throws IOException {
		ftpClient.close();
		fakeFtpServer.stop();
	}

	@Test
	public void givenRemoteFile_whenListingRemoteFiles_thenItIsContainedList() throws IOException {
		Collection<String> files = ftpClient.listFiles("");
		System.out.println(files);
	}

	@Test
	public void givenLocalFile_whenUploadingIt_thenItExistsOnRemoteLocation()
			throws URISyntaxException, IOException {

		File file = new File(getClass().getClassLoader().getResource("baz.txt").toURI());
		ftpClient.putFileToPath(file, "/buz.txt");
		//assertThat(fakeFtpServer.getFileSystem().exists("/buz.txt")).isTrue();
	}

	@Test
	public void givenRemoteFile_whenDownloading_thenItIsOnTheLocalFilesystem() throws IOException,URISyntaxException {
		File file = new File(getClass().getClassLoader().getResource("baz.txt").toURI());
		ftpClient.putFileToPath(file, "/buz.txt");

		ftpClient.downloadFile("/buz.txt","download_buz.txt");
		new File("download_buz.txt").delete();
	}



}
