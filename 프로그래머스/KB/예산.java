// https://school.programmers.co.kr/learn/courses/30/lessons/12982

import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum=0;
        
        //정렬
        Arrays.sort(d);
    
        //하나씩 더하자
        for(int i=0; i< d.length; i++){
            if(sum+d[i] <= budget){
                sum += d[i];
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
