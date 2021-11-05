package com.hemalatha.recursion;

public class EncryptedString {

    //https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=223547538732703&ppid=454615229006519&practice_plan=0
    public static void main(String[] args) {
        EncryptedString encryptedString = new EncryptedString();
        System.out.println("Expected = abc "+"Got = "+encryptedString.findEncryptedWord("bac"));
        System.out.println("Expected = bacd "+"Got ="+encryptedString.findEncryptedWord("abcd"));
        System.out.println("Expected = xbacbca "+"Got ="+encryptedString.findEncryptedWord("abcxcba"));
        System.out.println("Expected = eafcobok "+"Got ="+encryptedString.findEncryptedWord("facebook"));
    }

    String findEncryptedWord(String s) {
        StringBuilder sb= new StringBuilder();
        encryptString(sb,s,0,s.length()-1);
        return sb.toString();
    }

    public void encryptString(StringBuilder sb,String s, int left,int right){
        if(left>right){
            return;
        }

        int mid = left + ((right-left)/2);
        sb.append(s.charAt(mid));
        encryptString(sb,s,left,mid-1);
        encryptString(sb,s,mid+1,right);
    }

}
