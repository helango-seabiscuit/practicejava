package com.hemalatha.jcg.download;

import com.hemalatha.jcg.download.factory.FileDownload;
import com.hemalatha.jcg.download.factory.FileDownloadFactory;

public class DownloadFile {


	public static void main(String[] args) {

		String url = "http://cs.winona.edu/lin/cs440/ch04.pdf";
		downloadFile(url);
	}

	public static boolean downloadFile(String downloadUrl){
//		FileDownload fileDownload = FileDownloadFactory.getFileDownLoadHandler("resumable");
//		fileDownload.download(downloadUrl,"samplefile.pdf");

		FileDownload fileDownload = FileDownloadFactory.getFileDownLoadHandler("io");
		fileDownload.download(downloadUrl,"samplefile.pdf");
		return true;
	}
}
