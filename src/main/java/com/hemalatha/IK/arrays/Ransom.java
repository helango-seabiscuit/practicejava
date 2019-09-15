package com.hemalatha.IK.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by helangovan on 3/14/17.
 */
public class Ransom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        Map<String,Integer> mag = new HashMap<>();
        for(String s:magazine){
            if(!mag.containsKey(s.trim())){
                mag.put(s.trim(),1);
            }else{
                int val = mag.get(s.trim());
                mag.put(s.trim(),val+1);
            }

        }

        String res=null;
        for(String s:ransom){
            if(!mag.containsKey(s.trim()) || mag.get(s.trim())<=0){
                res="No";
                break;
            }else{
                int val = mag.get(s.trim());
                mag.put(s.trim(),val-1);
            }
        }
        if(res==null){
            res="Yes";
        }
        System.out.print(res);
    }
}
