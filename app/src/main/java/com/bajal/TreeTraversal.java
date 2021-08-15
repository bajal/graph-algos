package com.bajal;

import java.util.*;

public class TreeTraversal {

    public static void main(String... args) {
        Map<Character, char[]> map = new HashMap<>();

        map.put('a', new char[] {'c','b'});
        map.put('b', new char[] {'d'});
        map.put('c', new char[] {'e'});
        map.put('d', new char[] {'f'});
        map.put('e', new char[] {});
        map.put('f', new char[] {});

        depthFirstPrint(map, 'a');
        System.out.println();
        breadthFirstPrint(map, 'a');
    }

    private static void breadthFirstPrint(Map<Character,char[]> map, char a) {
        Queue<Character> queue = new ArrayDeque<>();
        queue.add(a);

        while (queue.size() > 0){
            Character cur = queue.poll();
            System.out.print(cur + "-->");

            for(char c: map.get(cur)){
                queue.add(c);
            }
        }
    }

    private static void depthFirstPrint(Map<Character,char[]> map, char a) {
        Stack<Character> stack = new Stack<>();
        stack.push(a);

        while (stack.size() > 0) {
            Character cur = stack.pop();
            System.out.print(cur + "-->");

            for(char c : map.get(cur)){
                stack.push(c);
            }
        }

    }

}
