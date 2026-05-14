// https://leetcode.com/problems/number-of-islands/

import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        //모든 좌표에 대해서 찾아야 함
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // 섬이면서 아직 안간곳
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++; //카운트
                    bfs(i, j, grid, visited, n, m);
                }
            }
        }

        
        return count;
    }

    void bfs(int sr, int sc, char[][] grid, boolean visited[][], int n, int m){
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr,sc});
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll(); //현재 노드
            int r = cur[0];
            int c = cur[1];

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                //다음 노드가 갈수있는 곳인지
                if (0 <= nr && nr < n && 0 <= nc && nc < m){
                    if(grid[nr][nc]=='1' && !visited[nr][nc] ){  
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        
                    }
                    
                }
                

            }
            
        }

    }
}
