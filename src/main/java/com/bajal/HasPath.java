package com.bajal;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class HasPath {

    private static boolean hasPath(Map<Character,char[]> map, char src, char dest) {
        if (src == dest) return true;

        for (char c : map.get(src)) {
            if(hasPath(map, c, dest)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasPathBFS(Map<Character,char[]> map, char src, char dest) {
        Queue<Character> queue = new ArrayDeque<>();
        queue.add(src);

        while (queue.size() > 0) {
            Character cur = queue.poll();
            if(cur == dest){
                return true;
            }
            for (char c : map.get(cur)) {
                queue.add(c);
            }
        }
        return false;
    }
    /*
    *     a --> c --> e
    *     |
    *     v
    *     b --> d --> f
    */

    public static void main(String[] args) {
        Map<Character, char[]> map = new HashMap<>();

        map.put('a', new char[]{'c', 'b'});
        map.put('b', new char[]{'d'});
        map.put('c', new char[]{'e'});
        map.put('d', new char[]{'f'});
        map.put('e', new char[]{});
        map.put('f', new char[]{});

        System.out.println( hasPath(map, 'c', 'f') );
        System.out.println( hasPathBFS(map, 'a', 'f') );

    }


}
