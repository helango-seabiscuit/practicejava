package com.hemalatha.quiz;

public class QuizOne {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println(sb.equals(sb2));
        CharSequence cs = sb.equals(sb2)?sb:"Differ";
        System.out.println(cs);

    }


}


class OneValue{
    private final int x;

    public OneValue(){
        x = 99;
    }


}
