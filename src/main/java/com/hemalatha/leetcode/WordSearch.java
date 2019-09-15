package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordSearch {


	public static void main(String[] args) {
		WordSearch search = new WordSearch();

		List<String> arr =search.findWords(new char[][]{
		{'o','a','a','n'},
		{'e','t','a','e'},
		{'i','h','k','r'},
		{'i','f','l','v'}
		},new String[]{"oath","pea","eat","rain"});

		arr.forEach(s->{
			System.out.println(s);
		});

		arr =search.findWords(new char[][]{
				{'b','a','a','b','a','b'},{'a','b','a','a','a','a'},{'a','b','a','a','a','b'},{'a','b','a','b','b','a'},
				{'a','a','b','b','a','b'},{'a','a','b','b','b','a'},{'a','a','b','a','a','b'}},
				new String[]{"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"});

		arr.forEach(s->{
			System.out.println(s);
		});
	}

	public List<String> findWords(char[][] board, String[] words) {

		boolean visited[][];

		WordTrie root = new WordTrie();

		for(String s:words){
			WordTrie curr = root;
			for(int i=0;i<s.length();i++){
				if(curr.getTrie()[s.charAt(i)-'a'] == null){
					curr.getTrie()[s.charAt(i)-'a'] = new WordTrie();
				}
				curr = curr.getTrie()[s.charAt(i)-'a'];
				if(i==s.length()-1){
                 curr.setWord(true);
				}
			}
		}

		Set<String> res = new HashSet<>();

		for(int i=0;i<board.length;i++){
			for (int j=0;j<board[0].length;j++){
				if(root.getTrie()[board[i][j]-'a'] != null){
					visited = new boolean[board.length][board[0].length];
					dfs(i,j,board,visited,root.getTrie()[board[i][j]-'a'],res,""+board[i][j]);
				}
			}
		}
		return res.stream().collect(Collectors.toList());

	}

	public  void dfs(int i,int j,char[][]board,boolean[][]visited,WordTrie curr,Set<String> res,String s) {
	   if(visited[i][j]==true){
	   	return;
	   }
	   visited[i][j]=true;
	   if(curr.isWord()){
	   	res.add(s);
	   }
	   for(int[] n:getNeighbours(i,j,board.length,board[0].length)){
	   	   if(visited[n[0]][n[1]]==false && curr.getTrie()[board[n[0]][n[1]]-'a']!=null){
	   	   	 dfs(n[0],n[1],board,visited,curr.getTrie()[board[n[0]][n[1]]-'a'],res,s+board[n[0]][n[1]]);
		   }
	   }
	   visited[i][j]=false;
	}

	private List<int[]> getNeighbours(int i,int j,int row,int col){
        List<int[]> res = new ArrayList<>();
		if (i-1>=0){
			res.add(new int[]{i-1,j});
		}

		if (i+1<row){
			res.add(new int[]{i+1,j});
		}

		if (j-1>=0){
			res.add(new int[]{i,j-1});
		}

		if (j+1<col){
			res.add(new int[]{i,j+1});
		}

		return res;
	}

	public  void bfs(int i,int j,char[][]board,boolean[][]visited,WordTrie curr){
		Queue<int[]> queue = new LinkedList<>();
		Queue<WordTrie> tries = new LinkedList<>();
		queue.add(new int[]{i,j});
		tries.add(curr);
		visited[i][j] = true;
		while (!queue.isEmpty()){
				int[] p = queue.poll();
				curr = tries.poll();
				if (curr.getTrie()[board[p[0]][p[1]] - 'a'] == null) {
					curr.getTrie()[board[p[0]][p[1]] - 'a'] = new WordTrie();
				}
				curr = curr.getTrie()[board[p[0]][p[1]] - 'a'];
				if (p[0] - 1 >= 0 && visited[p[0]-1][p[1]] == false) {
					queue.add(new int[]{p[0] - 1, p[1]});
					visited[p[0]-1][p[1]] = true;
					tries.add(curr);
				}

				if (p[0] + 1 < board.length && visited[p[0] + 1][p[1]] == false) {
					queue.add(new int[]{p[0] + 1, p[1]});
					visited[p[0]+1][p[1]] = true;

					tries.add(curr);
				}

				if (p[1] - 1 >= 0 && visited[p[0]][p[1] - 1] == false) {
					queue.add(new int[]{p[0], p[1] - 1});
					visited[p[0]][p[1]-1] = true;
					tries.add(curr);
				}

				if (p[1] + 1 < board[0].length && visited[p[0]][p[1] + 1] == false) {
					queue.add(new int[]{p[0], p[1] + 1});
					visited[p[0]][p[1]+1] = true;
					tries.add(curr);
				}
		}

	}
}

class  WordTrie{

	private WordTrie[] trie;
	private boolean isWord;

	public WordTrie() {
		trie = new WordTrie[26];
	}

	public WordTrie[] getTrie() {
		return trie;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean word) {
		isWord = word;
	}
}
