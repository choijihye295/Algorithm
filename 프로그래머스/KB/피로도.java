//https://school.programmers.co.kr/learn/courses/30/lessons/87946

class Solution {
    int answer; //탐험한 던전수
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        dfs(k, dungeons, 0, visited); 
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, int count, boolean[] visited){
        int n = dungeons.length;
        answer = Math.max(answer, count);
        
        for(int i=0; i<n; i++){
            int min = dungeons[i][0]; //최소피로도
            int act = dungeons[i][1]; //소모피로도
            
            if(!visited[i] && k>=min){
                visited[i] = true; //i번 던전 선택
                dfs(k-act, dungeons, count+1, visited); //다음던전
                visited[i] = false; //i번 던전 선택 해제
            }
        }
    }
}
