package com.hemalatha.intparker;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFilesFinder {


	//private static Map<List<String>,Path>  dupTracker = new HashMap<>();
	private static Map<String,Path>  dupTracker = new HashMap<>();
	private static List<Pair<Path,Path>> dups = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		String path = "/Users/helangovan/tmp";

		Files.walk(Paths.get(path),5, FileVisitOption.FOLLOW_LINKS)
				.forEach(p->{
			                      if(!Files.isDirectory(p.toAbsolutePath())) {
									  findDuplicate(p);
									  System.out.println(p.getFileName());
								  }
						    });



		System.out.println("DUPLICATE FILES ORIGINAL -------> DUPLICATES");
		dups.forEach(d -> {System.out.println(d.getLeft() +"----> "+ d.getRight());});
	}

	private static void findDuplicate(Path p){
		try {
			int bufferSize = 1024;
//			List<String> contents = Files.readAllLines(p);
            String content = null;
			long totalSize = Files.size(p);
			if(totalSize < bufferSize){
				content = new String(Files.readAllBytes(p));
			}else {
				InputStream stream = Files.newInputStream(p);
				StringBuilder sb = new StringBuilder();
				byte b[] = new byte[bufferSize];
				BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
				long off = (totalSize - (bufferSize *3))/2;
				long offset = 0;
				for(int i=0;i<3;i++) {
					int  read = bufferedInputStream.read(b,0,bufferSize);
					if(read ==-1){
						break;
					};
					sb.append(b);
					bufferedInputStream.skip(off);

				}
				content = sb.toString();
			}
			//System.
			if(dupTracker.containsKey(content)){
				Path inMap = dupTracker.get(content);

				Pair<Path,Path> res = Files.getLastModifiedTime(inMap)
						.compareTo(Files.getLastModifiedTime(p)) > 0 ? new ImmutablePair<>(p.getFileName(),inMap.getFileName())
						                                               :new ImmutablePair<>(inMap.getFileName(),p.getFileName());
				dups.add(res);
				dupTracker.put(content,res.getRight());
				return;
			}
			dupTracker.put(content,p);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
