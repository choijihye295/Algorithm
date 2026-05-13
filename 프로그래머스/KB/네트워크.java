// https://school.programmers.co.kr/learn/courses/30/lessons/43162
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        //모든 컴퓨터 dfs
        for(int i=0; i<n; i++){
            if (visited[i]) continue; //이미 방문한거 건너뜀
            dfs(n, computers, visited, i); //방문 안한거 dfs
            answer++; //dfs끝남 == 네트워크 1개
        }
        
        return answer;
    }
    
    void dfs(int n, int[][] computers, boolean[] visited, int cur){
        visited[cur] = true;
        
        for(int i=0;i<n;i++){
            if(!visited[i] && computers[cur][i] == 1){
                dfs(n, computers, visited, i);
            }
        }
    }
}
