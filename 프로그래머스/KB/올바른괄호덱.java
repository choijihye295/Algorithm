// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if(len%2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

//시간복잡도 효율성 테스트 통과 못함  - 프로그래머스 서버문제
