// https://leetcode.com/problems/keys-and-rooms/description/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        //visit 배열 
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        //0부터 시작
        q.add(0);
        visited[0] = true;

        int visitedCount = 0; //방문한 방의 개수를 세기

        while (!q.isEmpty()) {
            int cur = q.remove(); 

            visitedCount++; //방문한 방 개수 증가

            
            for (int key : rooms.get(cur)) {
                //아직 방문 안한곳이면 큐에 추가
                if (!visited[key]) {
                    visited[key] = true;
                    q.add(key);
                }
            }
        }
        
        return visitedCount == n; //모든 방 개수 == 방문한 방 개수
    }
}
