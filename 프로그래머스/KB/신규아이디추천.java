// https://school.programmers.co.kr/learn/courses/30/lessons/72410

import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계: 대문자 > 소문자
        answer = new_id.toLowerCase();
        // 2단계: 소문자, 숫자, 빼기, 밑줄, 마침표 제외 모든 문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        //3단계: 마침표 2번이상 연속 -> 하나의 마침표로
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // 4단계: 마침표가 맨앞/맨끝 제거
        if(answer.length() > 0 && answer.charAt(0) == '.'){
           answer = answer.substring(1);
        }
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.'){
           answer = answer.substring(0, answer.length()-1);
        }
    
        //5단계: 빈문자열이면 a대입
        if (answer.length() == 0) {
            //for(int i=0; i<new_id.length(); i++){
                answer = answer + "a";
            //}
        }
        
        //6단계: 16자 이상이면 0-15까지만
        if(answer.length() >= 16){
            answer = answer.substring(0,15);
            if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.'){
           answer = answer.substring(0, answer.length()-1);
            }
        }
        
        //7단계: 2자 이하라면 마지막 문자를 길이 3 될때까지 반복
        char last = answer.charAt(answer.length() - 1);
       
        while(answer.length()<3){
            answer = answer + last;
        }
        
        
        System.out.println(answer);
        return answer;
    }
    
}
