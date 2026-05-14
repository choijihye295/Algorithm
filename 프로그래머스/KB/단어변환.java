// https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>(); // 다른사람 풀이 참고
        
        //시작
        q.offer(begin);
        visited.put(begin, 0); 
        
        while(!q.isEmpty()){
            String cur = q.poll();
            int currentCnt = visited.get(cur);
            
            if(cur.equals(target)){ //target과 같아진경우
                return currentCnt;
            }
            
            for(String next : words){
                if(getDiffWord(cur, next) == 1 && !visited.containsKey(next)){
                    q.offer(next);
                    visited.put(next, currentCnt+1);
                }
            }
            
            
        }
        
        
        return 0;
    }
    
    //한글자만 다른지 확인하는 함수
    int getDiffWord(String word, String target){
        int diffCnt = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt;
    }
}
