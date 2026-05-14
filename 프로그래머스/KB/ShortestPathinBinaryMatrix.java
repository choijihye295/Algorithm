// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.*;
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sr = 0;
        int sc = 0;

        //출발지 도착지 1이면 애초에 이동 및 도착 못함 -> -1 리턴
        if(grid[sr][sc] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }

        boolean[][] visited = new boolean[n][m];

        int d = bfs(grid, visited, sr, sc, n, m);
        return d;
    }

    int bfs(int[][] grid, boolean[][]visited, int sr, int sc, int n, int m){
        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 1});
        visited[sr][sc] = true;


        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            System.out.println("방문 : "+ r + " "+c+" "+d);

            if(r == n-1 && c == m-1){
                return d;
            }

            for(int i=0; i<8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >=0 && nc < m){
                    if(grid[nr][nc]==0 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc,d+1});
                    }
                }
            }

        }

        return -1;
    }
}
