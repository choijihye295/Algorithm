// https://school.programmers.co.kr/learn/courses/30/lessons/12977

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0; //소수의 개수
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1; k<len; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    
                    //sum이 소수일때 answer 증가
                    if(isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        

        return answer;
    }
    
    public boolean isPrime(int sum){
        if(sum == 2) return true; //2는 소수
        
        for(int i=2; i<sum; i++){
            if(sum%i == 0){
                return false;
            }
        }
        return true;
    }
}
