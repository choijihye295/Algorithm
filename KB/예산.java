// https://campus.programmers.co.kr/tryouts/211582/challenges

import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum=0;
        
        //정렬
        Arrays.sort(d);
    
        //하나씩 더해서 예산 안넘는지 비교
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
