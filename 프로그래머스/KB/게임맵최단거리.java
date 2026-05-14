// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        answer = bfs(0,0,maps,visited);
        
        return answer;
    }
    int bfs(int sr, int sc, int[][] grid, boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        
        int[] dr = {0, 1, 0, -1}; //행 이동
        int[] dc = {1, 0, -1, 0}; //열 이동
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 1}); //시작노드 넣기. 거리 1
        visited[sr][sc] = true;
        
        while(!q.isEmpty()){
            //방문
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            //System.out.println("방문 : "+r+", "+c+" / 거리 : "+d);
            
            //도착한경우
            if(r == n-1 && c == m-1){ //0,0 부터 시작했기에 n,m이 아니라 -1씩 해줘야함
                return d;
            }
            
            
            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int nr = r + dr[i];
                int nc = c + dc[i];
    
                // 배열 범위 체크
                if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                // 이동 가능한지 확인
                    if(grid[nr][nc] == 1){
                        //다음노드 예약
                        if(!visited[nr][nc]){
                            q.offer(new int[]{nr, nc, d+1});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
