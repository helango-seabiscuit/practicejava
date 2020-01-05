package com.hemalatha.article;

import java.util.StringJoiner;

public class StringJoinerExample {

    public static void main(String[] args) {

        //String Joiner with delimiters
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("Hello");
        joiner.add("Hey");
        joiner.add("Hi");
        joiner.add("Hola");
        System.out.println(joiner);

        StringJoiner stringJoiner = new StringJoiner(":");
        stringJoiner.setEmptyValue("its default value when empty");
        System.out.println(stringJoiner);

        //String Joiner with prefix and suffix
        StringJoiner psjoiner = new StringJoiner(",","[","]");
        psjoiner.add("I");
        psjoiner.add("am");
        psjoiner.add("in");
        psjoiner.add("bracekts");
        System.out.println(psjoiner);

        //Two String Joiner merge
        StringJoiner merge = joiner.merge(psjoiner);
        System.out.println(merge);

        //merge with both joiner in prefix suffix
        StringJoiner psjoiner2 = new StringJoiner(",","{","}");
        psjoiner2.add("I");
        psjoiner2.add("am");
        psjoiner2.add("in");
        psjoiner2.add("curly");
        System.out.println(psjoiner2);
        psjoiner.merge(psjoiner2);
        System.out.println(psjoiner);
        System.out.println(psjoiner2.merge(psjoiner));

    }
}
