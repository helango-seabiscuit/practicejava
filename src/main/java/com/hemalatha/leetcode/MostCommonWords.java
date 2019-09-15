package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class MostCommonWords {

	public static void main(String[] args) {
		MostCommonWords words = new MostCommonWords();
		System.out.println(words.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));//ball
		System.out.println(words.mostCommonWord("a",new String[]{}));//a
		System.out.println(words.mostCommonWord("a, a, a, a, b,b,b,c, c" ,new String[]{"a"}));//b
		System.out.println(words.mostCommonWord("j. t? T. z! R, v, F' x! L; l! W. M; S. y? r! n; O. q; I? h; w. t; y; X? y, p. k! k, h, J, r? w! U! V; j' u; R! z. s. T' k. P? M' I' j! y. P, T! e; X. w? M! Y, X; G; d, X? S' F, K? V, r' v, v, D, w, K! S? Q! N. n. V. v. t? t' x! u. j; m; n! F, V' Y! h; c! V, v, X' X' t? n; N' r; x. W' P? W; p' q, S' X, J; R. x; z; z! G, U; m. P; o. P! Y; I, I' l' J? h; Q; s? U, q, x. J, T! o. z, N, L; u, w! u, S. Y! V; S? y' E! O; p' X, w. p' M, h! R; t? K? Y' z? T? w; u. q' R, q, T. R? I. R! t, X, s? u; z. u, Y, n' U; m; p? g' P? y' v, o? K? R. Q? I! c, X, x. r' u! m' y. t. W; x! K? B. v; m, k; k' x; Z! U! p. U? Q, t, u' E' n? S' w. y; W, x? r. p! Y? q, Y. t, Z' V, S. q; W. Z, z? x! k, I. n; x? z; V? s! g, U; E' m! Z? y' x? V! t, F. Z? Y' S! z, Y' T? x? v? o! l; d; G' L. L, Z? q. w' r? U! E, H. C, Q! O? w! s? w' D. R, Y? u. w, N. Z? h. M? o, B, g, Z! t! l, W? z, o? z, q! O? u, N; o' o? V; S! z; q! q. o, t! q! w! Z? Z? w, F? O' N' U' p? r' J' L; S. M; g' V. i, P, v, v, f; W? L, y! i' z; L? w. v, s! P?"
				 ,new String[]{"m","q","e","l","c","i","z","j","g","t","w","v","h","p","d","b","a","r","x","n"}));//b
		String t ="y!";
		System.out.println(t.substring(0,t.length()-1));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		Map<String,Integer> map = new HashMap<>();
		Set<String> bannedStrings = new HashSet<>();
		for(String s:banned){
			bannedStrings.add(s.trim().toLowerCase());
		}

		String res = null;
		int count = 0;
		StringTokenizer st = new StringTokenizer(paragraph);

		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			StringTokenizer stInternal = new StringTokenizer(str, ",");
			while (stInternal.hasMoreTokens()) {
				String s = stInternal.nextToken();

				//!?',;.
				if (s.endsWith("!") || s.endsWith("?") || s.endsWith(",") || s.endsWith(";") || s.endsWith(".") || s.endsWith("'")) {
					s = s.substring(0, s.length() - 1);
				}
				s = s.toLowerCase();
				if (bannedStrings.contains(s)) {
					continue;
				}
				if (map.get(s) != null) {
					if (map.get(s) + 1 > count) {
						count = map.get(s) + 1;
						res = s;
						map.put(s, count);
					} else {
						map.put(s, map.get(s) + 1);

					}
				} else {
					map.put(s, 1);
					if (res == null) {
						res = s;
						count = 1;
					}
				}
			}
		}
		return res;
	}
}
