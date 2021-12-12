package com.hemalatha.company.interview;

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {

    public static void main(String[] args) {
        FlattenDictionary dictionary = new FlattenDictionary();
        /**
         * {'a':
         *         {'b':
         *             {'c':
         *                 {'d':'e'}
         *             }
         *         }
         *     }
         */
        Map<String,Object> mp = new HashMap<>();
        mp.put("a",Map.of("b", Map.of("c",Map.of("d","e"))));
        Map<String,String> res = new HashMap<>();
        dictionary.flatten(mp, new StringBuilder(),res);
        System.out.println(res);
    }

    public void flatten(Map<String,Object> imiJsonObject, StringBuilder sb, Map<String,String> res){
        for(String key: imiJsonObject.keySet()){
            Object value = imiJsonObject.get(key);
            if(value instanceof  Map){
                sb.append(key).append(".");
                flatten((Map<String, Object>) value, sb,res);
            } else if (value instanceof  String){
                sb.append(key);
                res.put(sb.toString(), (String) value);
            }
        }
    }
}
