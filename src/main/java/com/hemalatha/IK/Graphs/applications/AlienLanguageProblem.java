package com.hemalatha.IK.Graphs.applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//Given a sorted dictionary of an alien language, find order of characters
//Ex: {"baa","abcd","abcda","cab","cad"} --> o/p: b,d,a,c
//Ex: {"caa","aaa","aab"} --> o/p: c,a,b
public class AlienLanguageProblem {

    static class Vertex{
        char w;
        Set<Vertex> neighbours;
        Vertex(char v){
            this.w = v;
            neighbours = new HashSet<>();
        }
    }
    static Map<Character,Vertex> map;
    static List<Character> list;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        String[] words = new String[size];
        for(int i=0;i<size;i++){
             words[i] =in.nextLine();
        }
        String res = findOrder(words);
        System.out.println(res);
    }
    static String findOrder(String[] strDict) {
        buildGraph(strDict);
        Set<Vertex> visited = new HashSet();
        Stack<Vertex> result = new Stack<>();
        for(Character c:list){
            Vertex k = map.get(c);
            if(!visited.contains(k)){
                topoSort(k,visited,result);
            }
        }
        String s ="";
        while(!result.isEmpty()){
            s+=result.pop().w;
        }
        return s;

    }

    public static void topoSort(Vertex v,Set<Vertex> visited,Stack<Vertex> result){
        if(visited.contains(v)){
            return;
        }
        visited.add(v);
        for(Vertex n:v.neighbours){
            topoSort(n,visited,result);
        }
        result.push(v);
    }


    static void buildGraph(String[] strDict){
        map = new HashMap<Character,Vertex>();
        list = new ArrayList();
        Vertex first=null;
        Vertex second = null;
        for(int i=0;i<strDict.length-1;i++){
            int index = differPosition(strDict[i],strDict[i+1]);
            char f = strDict[i].toCharArray()[index];
            char s = strDict[i+1].toCharArray()[index];
            first = map.get(f);
            if(first==null){
                first = new Vertex(f);
                list.add(f);
                map.put(f,first);
            }
            second = map.get(s);
            if(second==null){
                second = new Vertex(s);
                list.add(s);
                map.put(s,second);
            }
            first.neighbours.add(second);
        }
    }

    public static int differPosition(String first,String second){
        char [] farr = first.toCharArray();
        char [] sarr = second.toCharArray();
        int len1 = farr.length;
        int len2 = sarr.length;
        int i=0;
        for(;i<=len1 && i<len2;i++){
            if(farr[i]!=sarr[i]){
                return i;
            }
        }
        return i;
    }

}
