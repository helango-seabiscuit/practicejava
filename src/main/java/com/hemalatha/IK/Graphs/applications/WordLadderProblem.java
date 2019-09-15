package com.hemalatha.IK.Graphs.applications;


//Given list of words (dictionary) given multiple queries (w1,w2) print path taken for w1 to reach w2
//words are already in dictionary
//each word differs from prev word in path by exactly 1 character
//CAT,RAT,BAT,BAR,CAR,HAT
//ex: query(CAT,BAR) ->[CAR,CAR,BAR]
//ex: query(BAR,HAT) ->[BAR,CAR,CAT,HAT]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class WordVertex{
    char words[];
    Set<WordVertex> neighbours;

    WordVertex(String word){
        words = word.toCharArray();
        neighbours = new HashSet<>();
    }

    public boolean isVertex(String word){
        return  word.equals(new String(this.words));
    }

    public void addWord(WordVertex word){
         if(isOneCharacterDiffer(word)) {
             neighbours.add(word);
         }
    }

    public boolean isOneCharacterDiffer(WordVertex word){
        char[] temp = word.words;
        int count = 0;
        for(int i=0;i<this.words.length;i++){
            if(temp[i]!=words[i]){
                count++;
            }
            if(count>1){
                break;
            }
        }
        if(count==0 &&  temp.length==words.length+1){
            return  true;
        }
        return count ==1;
    }
}

public class WordLadderProblem {

    static  HashMap<String,WordVertex> vertices;
    public static void main(String[] args) {
        vertices = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int listSize = Integer.parseInt(in.nextLine().trim());
        for(int i=0;i<listSize;i++){
            String word = in.nextLine().trim();
            WordVertex wordVertex = new WordVertex(word);
            vertices.put(word,wordVertex);
        }
        String q1 = in.nextLine().trim();
        String q2 = in.nextLine().trim();
        buildDictionary(new LinkedList<>(vertices.values()));
        findPathWords(vertices.get(q1),vertices.get(q2));
    }

    public  static void buildDictionary(List<WordVertex> words){
        for(int i=0;i<words.size();i++){
            WordVertex wi = words.get(i);
            for(int j=0;j<words.size();j++){
                if(wi!=words.get(j)) {
                        wi.addWord(words.get(j));
                }
            }
        }

    }

    public static  void findPathWords(WordVertex start,WordVertex end){
        Queue<WordVertex> queue = new LinkedList<>();
        queue.add(start);
        Map<WordVertex,WordVertex> backReferences = new HashMap<>();
        while (!queue.isEmpty()){
            WordVertex w = queue.poll();
            if(w==end){
                break;
            }

            for(WordVertex n:w.neighbours){
                if(!backReferences.containsKey(n)){
                    backReferences.put(n,w);
                }
                queue.add(n);
            }
        }

        if(!backReferences.containsKey(end)){
            return;
        }
        WordVertex curr = end;
        List<WordVertex> resultPath = new ArrayList<>();
        while (curr!=start){
            resultPath.add(0,curr);
            curr = backReferences.get(curr);
        }
        resultPath.add(0,start);

        for (WordVertex w:resultPath){
            System.out.print( new String(w.words)+" ");
        }
    }


}
