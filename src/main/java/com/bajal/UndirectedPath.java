package com.bajal;

import com.bajal.utils.Pair;

import java.util.*;

public class UndirectedPath {

    public static void main(String[] args) {
        List<Pair<Character, Character>> edges = new ArrayList<>();
        edges.add(new Pair<>('i', 'j'));
        edges.add(new Pair<>('k', 'i'));
        edges.add(new Pair<>('m', 'k'));
        edges.add(new Pair<>('k', 'l'));
        edges.add(new Pair<>('o', 'n'));

        System.out.println(edges);

        // Convert edges list to Adjacency list
        Map<Character, List<Character>> map = convertToAdjacencyList(edges);
        printGraphAsMap(map);

        System.out.println("Has path from src to dest :" + hasPath(map, 'i', 'l', new HashSet<>()));
    }

    private static boolean hasPath(Map<Character, List<Character>> map, char src, char dest, HashSet<Object> visited) {
        if(src == dest) return true;
        if(visited.contains(src)) return false;

        visited.add(src);
        for(char c: map.get(src)) {
            return hasPath(map, c, dest, visited);
        }

        return false;
    }

    private static void printGraphAsMap(Map<Character, List<Character>> map) {
        for(Map.Entry<Character, List<Character>> cs: map.entrySet()){
            System.out.print(cs.getKey() + " =>");
            System.out.println(cs.getValue().toString());
        }
    }

    private static Map<Character,List<Character>> convertToAdjacencyList(List<Pair<Character, Character>> edges) {
        Map<Character,List<Character>> map = new HashMap<>();
        for(Pair<Character, Character> edge: edges) {
            List<Character> charsToAdd = new ArrayList<>();
            charsToAdd.add(edge.getSecond());
            if(map.get(edge.getFirst()) == null) {
                map.put(edge.getFirst(), charsToAdd);
            } else  {
                charsToAdd.addAll(map.get(edge.getFirst()));
                map.put(edge.getFirst(), charsToAdd);
            }
            charsToAdd = new ArrayList<>();
            charsToAdd.add(edge.getFirst());
            if(map.get(edge.getSecond()) == null) {
                map.put(edge.getSecond(), charsToAdd);
            } else  {
                charsToAdd.addAll(map.get(edge.getSecond()));
                map.put(edge.getSecond(), charsToAdd);
            }
        }
        return map;
    }
}
