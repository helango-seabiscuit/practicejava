package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 Input: dict = ["cat", "bat", "rat"]
 sentence = "the cattle was rattled by the battery"
 Output: "the cat was rat by the bat"
 */
public class ReplaceWords {

	private DictWord root;

	public static void main(String[] args) {
		ReplaceWords words = new ReplaceWords();
		//System.out.println(words.replaceWords(Arrays.asList("cat","bat","rat"),"the cattle was rattled by the battery"));
		System.out.println(words.replaceWords(Arrays.asList("e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"),"ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"));

	}
	public String replaceWords(List<String> dict, String sentence) {
		DictWord root = new DictWord(false);

		for(String s:dict){
			DictWord curr = root;
			for(int i=0;i<s.length();i++){
				char c = s.charAt(i);
				DictWord w = curr.getChild(c);
				if(w==null){
					w = new DictWord(i==s.length()-1);
				}
				curr.getChildren()[c-'a']=w;
				if(i==s.length()-1){
					w.setWord(true);
				}
				curr = w;
			}
		}

		StringBuilder res = new StringBuilder();
		StringTokenizer st = new StringTokenizer(sentence);
		while (st.hasMoreTokens()){
			String s = st.nextToken();
			DictWord curr = root;
			boolean isRoot = false;
			for(int i=0;i<s.length();i++){
               char c = s.charAt(i);
               DictWord w = curr.getChild(c);
               if(w == null){
               	 break;
			   }else{
               	   if(w.isWord()){
               	   	 res.append(" "+s.substring(0,i+1));
               	   	 isRoot = true;
               	   	 break;
				   }
				   curr = w;
			   }
			}
			if(!isRoot){
				res.append(" "+s);
			}
		}
		return res.toString();
	}
}

class DictWord{
	private boolean isWord;
	private DictWord[] children;


	public DictWord(boolean isWord) {
		this.children = new DictWord[26];
		this.isWord = isWord;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean word) {
		isWord = word;
	}

	public DictWord getChild(char c) {
		return children[c-'a'];
	}

	public DictWord[] getChildren() {
		return children;
	}


}
