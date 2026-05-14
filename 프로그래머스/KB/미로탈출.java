// https://school.programmers.co.kr/learn/courses/30/lessons/159993

import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        //maps 를 이차원 char[][]으로 가공해야함
        char[][] charArr = new char[maps.length][];

        for (int i = 0; i < maps.length; i++) {
            charArr[i] = maps[i].toCharArray(); // 각 문자열을 char 배열로 변환
            //System.out.println(charArr[i]);
        }
        
        int n = charArr.length;
        int m = charArr[0].length;
        //System.out.println(n+" "+m);
        
        int[] start = new int[2];
        int[] lovel = new int [2];
        int[] exit = new int[2];

        //좌표구하기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(charArr[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                if(charArr[i][j] == 'L'){
                    lovel[0] = i;
                    lovel[1] = j;
                }
                if(charArr[i][j] == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }
                    
                    
            }
        }

        // S -> L 로 가는 최단거리
        int cnt_L = bfs(charArr, start[0], start[1],lovel[0], lovel[1]);
        System.out.println(cnt_L);
        if(cnt_L == -1) return -1;
        
        // L -> E 로 가는 최단거리
        int cnt_E = bfs(charArr, lovel[0], lovel[1], exit[0], exit[1]);
        System.out.println(cnt_E);
        if(cnt_E == -1) return -1;
        
        answer = cnt_L + cnt_E;
        System.out.println(answer);
        
        return answer;
    }
    
    int bfs(char[][] maps, int sr, int sc, int er, int ec){
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr,sc,0});
        visited[sr][sc] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            
            if(r == er && c == ec){
                return d;
            }
            
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr>=0 && nr < n && nc>=0 && nc<m){
                    if(maps[nr][nc] != 'X' && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc, d+1});
            
                    }
                }
            }
        }
        
        
        return -1;
    }
}
