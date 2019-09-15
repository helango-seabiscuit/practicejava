package com.hemalatha.interview.patternsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStringSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  matchString("hema", "hemalathahemalatha");
	  System.out.println("LAst cyberword: "+lastCyberWord("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
	 // removeWebLink("http.//say.org,www.jeeves.x.info,www.comhttp://.tv");
	  removeWebLink("abctgrabchgtdceert");
	  getMatchedCodes("UUDDLRRLLRBASS", new String[]{"UUDDLRLRBA","UUDUDLRLRABABSS","DDUURLRLAB","UUDDLRLRBASS","UDLRRLLRBASS"}
);
	  List<String> s= new ArrayList<String>(0);
	  for(String st:s)
		  System.out.println(st);

	}
	
	
	
	public static void matchString(String match,String input){
		Pattern p = Pattern.compile(match);
		Matcher matcher=p.matcher(input);
		
		while(matcher.find()){
			System.out.println("Found match at :"+matcher.start());
		}
	}
	
	public static String lastCyberWord(String cyberLines){
		String []cyberWords = cyberLines.replaceAll("-", "")
		                       .replaceAll("[^a-zA-Z0-9@]", " ")
		                       .split(" ");
		
		return cyberWords[cyberWords.length-1];
	}
	
	public static String removeWebLink(String webContent){
		String webRegex = "((www.)|(http://)(www.)?)[a-zA-Z0-9.]+[.](com|info|tv|edu|org)";
		//String webRegex = "(abc)|(cba)|(dce)";
		
		String[] matchers = webContent.split(webRegex);
		for(int i =0 ;i<matchers.length;i++)
			System.out.println("Mathc: "+matchers[i]);
		
		return matchers[0];
	}
	
	public static void getMatchedCodes(String input,String []regex){
		int len = 0;
		
		for(int j =0;j<regex.length;j++){
			len = regex[j].length();
		String conRegex = ".*";
		for(int i =0;i<len;){
			int n = 1;
			while((n+i)<len && regex[j].charAt(n+i)== regex[j].charAt(i))
				n++;			
			conRegex = conRegex+regex[j].charAt(i)+"{"+n+",}";
			i=n+i;
		}
		conRegex+=".*";
		System.out.println("Constructed Regex: "+conRegex);
		Pattern p = Pattern.compile(conRegex);
		Matcher m = p.matcher(input);
		while(m.find()){
			System.out.println("Matched  "+m.group()+" at :"+m.start());
		}
	}
	}
	
	
	
	

}
