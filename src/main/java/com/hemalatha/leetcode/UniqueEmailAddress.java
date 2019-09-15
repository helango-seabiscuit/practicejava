package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class UniqueEmailAddress {

	public static void main(String[] args) {
//		String s = "hema+test@gmail.com";
//		System.out.println(s.split("@")[0].split("\\+")[0]);
//		System.out.println(s.split("@")[1]);

		UniqueEmailAddress emailAddress = new UniqueEmailAddress();
		//System.out.println(emailAddress.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
		System.out.println(emailAddress.test(new String[]{"9001 discuss.leetcode.com"}));
		System.out.println(emailAddress.test(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
	}


	public int numUniqueEmails(String[] emails) {

		Set<String> res = new HashSet<>();
		for(String email:emails){
			String[] splits = email.split("@");
			String local = splits[0];
			String domain = splits[1];
			int plusIndex = local.indexOf("+");
			if(plusIndex != -1){
				local = local.substring(0,plusIndex);
			}
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(local,".");
			while (st.hasMoreTokens()){
				sb.append(st.nextToken());
			}
			sb.append("@"+domain);
			res.add(sb.toString());

		}
		return res.size();

	}

	public List<String> test(String[] cpdomains){
		Map<String,Integer> counts = new HashMap<>();
		for(String d:cpdomains){
			StringTokenizer st = new StringTokenizer(d);
			int count = Integer.valueOf(st.nextToken());
			String domain = st.nextToken();
			String [] dms = domain.split("\\.");
			StringBuilder sb=new StringBuilder();
			for(int i=dms.length-1 ;i>=0;i--){
				sb.insert(0,dms[i]);
				counts.put(sb.toString(),counts.getOrDefault(sb.toString(),0)+count);
				sb.insert(0,".");
			}
		}
		List<String> res = new ArrayList<>();
		for(String s:counts.keySet()){
			res.add(counts.get(s) +" "+s);
		}

		return res;
	}
}
