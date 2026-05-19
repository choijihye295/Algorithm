//https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, target, 0,0); 
        
        return answer;
    }
    
    int dfs(int[] numbers, int target, int idx, int sum){
        int count = 0;
        if(idx == numbers.length){
            if(target==sum) return 1; //타겟이랑 합이랑 같아야 1리턴
            else return 0;
        }
        
        //+랑 -랑 둘다 해보기
        count += dfs(numbers, target, idx+1, sum+numbers[idx]); //리턴은 count에 더해짐
        count += dfs(numbers, target, idx+1, sum-numbers[idx]);
        
        return count;
    }
}
