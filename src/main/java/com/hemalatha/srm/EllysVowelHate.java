package com.hemalatha.srm;

public class EllysVowelHate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Length of tourist :"+getLength("tourist") );
		System.out.println("Length of tourist :"+getLength("eagaeoppooaaa") );
		System.out.println("Length of tourist :"+getLength("esprit") );
		System.out.println("Length of tourist :"+getLength("ayayayayayaya") );
		System.out.println("Length of tourist :"+getLength("ababababababababababababababababababababababababab" ));
		System.out.println("Length of tourist :"+getLength("naaaaaaaanaaaanaananaaaaabaaaaaaaatmaaaaan") );

	}
	
	/*public static int getLength(String nickname){
        Set<String> vow = new HashSet<String>(6);
        vow.add("a");
        vow.add("e");
        vow.add("i");
        vow.add("o");
        vow.add("u");
        vow.add("y");

        String prev = nickname.substring(0,1);
        //System.out.println(prev);
       int length = 1;
        String curr = null;
        for(int i=1;i<nickname.length();i++){
             curr = nickname.substring(i,i+1);
             if(!vow.contains(curr) || (!vow.contains(prev))){
                 prev = curr;
                 length++;
             }
        }       
        return length;
    }*/
	
	//Top coder method
	public static int getLength(String nickname){
		return nickname.replaceAll("[aeiouy]+", "a").length();
	}

}
