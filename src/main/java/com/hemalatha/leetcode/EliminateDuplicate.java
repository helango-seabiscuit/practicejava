package com.hemalatha.leetcode;

import java.util.Collections;
import java.util.List;

public class EliminateDuplicate {

    static class Name implements  Comparable<Name> {
        String firstName;
        String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Name o) {
            int cmp = this.firstName.compareTo(o.firstName);
            if (cmp == 0){
                cmp = this.lastName.compareTo(o.lastName);
            }
            return cmp;
        }
    }

    public static void main(String[] args) {
        List<Name> names = List.of(new Name("Ian","Botham"),new Name("David","Gower"),new Name("Ian","Bell"),
                new Name("Ian","Chappell"));
        eliminateDups(names);
        System.out.println(names);
    }

    public static void eliminateDups(List<Name> names){
        Collections.sort(names);
        int result = 0;
        for(int index = 1; index < names.size();index++){
            if(!names.get(result).equals(names.get(index))){
                names.set(++result, names.get(index));
            }
        }
        names.subList(++result, names.size()).clear();
    }
}
