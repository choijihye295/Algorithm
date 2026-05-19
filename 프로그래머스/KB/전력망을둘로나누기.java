//https://school.programmers.co.kr/learn/courses/30/lessons/86971

import java.util.*;
class Solution {
    List <List<Integer>> graph;
    int[] subTreeSize;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){ //주의!
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        subTreeSize = new int[n+1];
        visited = new boolean[n+1];
        
        dfs(1);
        
        int answer = Integer.MAX_VALUE; //주의! 맥스로 해야함
        for(int i=2; i<=n; i++){ 
            int gA = subTreeSize[i];
            int gB = n - gA;
            int diff = Math.abs(gA-gB); //절대값 차
            answer = Math.min(answer, diff); //최소
        }
        
        return answer;
    }
    
    int dfs(int node){
        visited[node] = true;
        subTreeSize[node] = 1;
        
        for(int lr : graph.get(node)){
            if(!visited[lr]){
                dfs(lr);
                subTreeSize[node] += subTreeSize[lr];
            }
        }
        
        return subTreeSize[node];
    }
}
