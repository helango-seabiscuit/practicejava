package com.hemalatha.jcg.file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FIleWritingMethods {

	public static void main(String[] args) {

		System.out.printf("start");
		String filename = "hello.txt";
//		writeUsingBufferedWriter(filename);
//		writeUsingPrintWriter(filename);
//		writeUsingFileOutputStream(filename);
		lockFile(filename);
		writeUsingRandomAccessFile(filename,5);

	}

	public static void writeUsingBufferedWriter(String filename){

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
			writer.write("Hello");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void  writeUsingPrintWriter(String filename){

		try (FileWriter fileWriter = new FileWriter(filename,true);
			PrintWriter printWriter = new PrintWriter(fileWriter)) {
			printWriter.print("Some string");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void writeUsingFileOutputStream(String filename){
		try(FileOutputStream outputStream = new FileOutputStream(filename)){
			String str = "Hello fileoutputstream";
			byte[] strBytes = str.getBytes();
			outputStream.write(strBytes);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static  void writeUsingRandomAccessFile(String filename, int pos){

		try(RandomAccessFile accessFile = new RandomAccessFile(filename,"rw")){
			accessFile.seek(pos);
			accessFile.write("accessfile".getBytes());
		}catch (Exception e){
			e.printStackTrace();
		}

		try(RandomAccessFile accessFile = new RandomAccessFile(filename,"r")){
			accessFile.seek(pos);
			String s = accessFile.readLine();
			System.out.println(s);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public static  void lockFile(String filename){
		FileLock lock = null;
		try(RandomAccessFile randomAccessFile = new RandomAccessFile(filename,"rw");
			FileChannel channel = randomAccessFile.getChannel()){

			lock = channel.tryLock();
			randomAccessFile.seek(20);
			randomAccessFile.write("test lock".getBytes());

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(lock != null && lock.isValid()){
				try {
					lock.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


}
