package com.hemalatha.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<List<String>> its = List.of(List.of("JFK","KUL"),List.of("JFK","NRT"),List.of("NRT","JFK"));
        System.out.println(reconstructItinerary.findItinerary(its));
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,Node> map = new HashMap<>();

        Node jfk = null;
        for(List<String> st: tickets){
            String source = st.get(0);
            String destination = st.get(1);
            Node snode = map.getOrDefault(source, new Node(source));
            Node dnode = map.getOrDefault(destination, new Node(destination));
            snode.destinations.add(dnode);
            if(source.equals("JFK")){
                jfk = snode;
            }
            map.put(source,snode);
            map.put(destination,dnode);
        }

        List<String> res = new ArrayList<>();
        dfs(jfk, res);
        return res;
    }

    private void dfs(Node curr, List<String> res){

        while(!curr.destinations.isEmpty()){
            Node n = curr.getDestinations().remove(0);
            dfs(n,res);
        }
        res.add(0,curr.code);
    }

    static class Node {
        String code;
        List<Node> destinations;

        public Node(String code){
            this.code = code;
            destinations = new ArrayList<>();
        }

        List<Node> getDestinations(){
            Collections.sort(destinations, (n1, n2)-> (n1.code.compareTo(n2.code)));
            return destinations;
        }
    }
}
