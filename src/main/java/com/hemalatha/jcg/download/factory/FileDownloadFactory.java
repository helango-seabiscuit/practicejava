package com.hemalatha.jcg.download.factory;

import com.hemalatha.jcg.download.factory.resumable.ResumableDownload;

public class FileDownloadFactory {

   private FileDownloadFactory(){}


   public static FileDownload getFileDownLoadHandler(String type){
   	 if("resumable".equalsIgnoreCase(type)){
   	 	return new ResumableDownload();
	 }
	 if("io".equalsIgnoreCase(type)){
   	 	return new IODownload();
	 }
	 if("io7".equalsIgnoreCase(type)){
   	 	return new IO7Download();
	 }
	 if("nio".equalsIgnoreCase(type)){
   	 	return new NIODownload();
	 }
	 if("apache".equalsIgnoreCase(type)){
   	 	return new ApacheDownload();
	 }
	 if("async".equalsIgnoreCase(type)){
   	 	return new AsyncFileDownload();
	 }
	 return null;
   }

}
