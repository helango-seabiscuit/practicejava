package com.hemalatha.leetcode;

import java.util.PriorityQueue;

public class BoldStrings {


	public String boldWords(String[] words, String S) {
		PriorityQueue<Range> pq = new PriorityQueue<Range>((r, s)-> { return Integer.compare(r.start,s.start);} );
		for(String s: words){
			int k = S.indexOf(s);
			if (k >= 0){
				Range r = new Range(k, k+s.length()-1);
				if (!pq.isEmpty() && pq.peek().end >= k){
					Range rn = pq.poll();
					rn.end = k+s.length()-1;
					pq.offer(rn);
				}else{
					pq.offer(r);
				}
			}
		}

		StringBuilder sb = new StringBuilder(S);
		int c = 0;
		while(!pq.isEmpty()){
			Range r = pq.poll();
			sb.insert(r.start+c,"<b>");
			sb.insert(r.end+4,"</b>");
			c += 6;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BoldStrings boldStrings = new BoldStrings();
		System.out.println(boldStrings.boldWords(new String[]{"ab","bc"}, "aabcd"));
	}


	static class Range {
		public Integer start;
		public Integer end;

		public Range(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}
	}
}
