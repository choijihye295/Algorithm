//https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0; //가장 멀리 떨어진 노드 개수
        
        //2차원 배열을 인접행렬로 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        //양방향 연결해야함
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        //bfs 템플릿
        boolean[] visited = new boolean[n+1]; //1번노드 셀 필요 없음
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0}); //현재노드번호 1, 거리 0
        visited[1] = true;
        
        int max = 0; //최대 거리
        
        //bfs 템플릿
        while(!queue.isEmpty()){
            //답 구하는 부분!!
            int[] cur = queue.remove();
            
            if(max < cur[1]){ //현재 max거리보다 더 먼 경우
                max = cur[1]; //거리 갱신
                answer = 1;
            } else if (max ==cur[1]){ //현재 max거리와 같은경우
                answer++; //노드개수 추가
            } 
            
            //bfs
            for (int next : graph.get(cur[0])) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(new int[]{ next, cur[1] + 1 });
            }
        }
        
        
        return answer;
    }
}
