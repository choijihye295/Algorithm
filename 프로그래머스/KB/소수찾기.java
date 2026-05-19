//https://school.programmers.co.kr/learn/courses/30/lessons/42839

import java.util.*;
class Solution {
    Set<Integer> primeSet; //소수모음
    public int solution(String numbers) {
        int answer = 0;
        
        primeSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(numbers, visited, "");
        
        return primeSet.size();
    }
    
    void dfs(String numbers, boolean[] visited, String cur){
        if(cur.length() != 0) { //현재 문자열
            int num = Integer.parseInt(cur); //숫자로 바꾸고
            if(isPrime(num)) primeSet.add(num); //소수면 set에 추가
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, visited, cur+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2; i*i <= num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
