// https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //유저 당 신고한 id 중복없이 저장
        Set<String> set = new HashSet<>();
        
        for (String element : report) {
            set.add(element);
        }
        
        // System.out.println("HashSet: " + set);

        //신고당한 개수 세기
        Map<String, Integer> map = new HashMap<>();
        
        // 결과를 담을 리스트 (각 요소가 [0]=신고한 유저, [1]=신고당한 유저 형태)
        List<String[]> resultList = new ArrayList<>();

        for (String s : set) {
            // 공백을 기준으로 분리 (검색함)
            String[] parts = s.split(" "); 
            if (parts.length >= 2) {
                // parts[0] -> 앞부분, parts[1] -> 뒷부분
                resultList.add(parts);
            }
        }
        
        // 신고당한 개수 넣기
        for (String[] res : resultList) {
            //System.out.println("0번: " + res[0] + ", 1번: " + res[1]);
            map.put(res[1], map.getOrDefault(res[1], 0)+1);
            //System.out.println("신고 카운트 결과: " + map);
        }
        
        // k개 이상인 경우 정지 -> 메일 보내기
        for(String[] res : resultList){
        
		        // ------ 검색함
		        
		        //이렇게 변수로 만드는 아이디어를 생각 못함
            String reporter = res[0]; // 신고한 사람
            String target = res[1];   // 신고당한 사람
            
            if(map.get(res[1]) >= k){
                // 신고한 사람이 id_list의 몇 번째인지 찾기 -> 이 부분 생각 못함
                for (int i = 0; i < id_list.length; i++) {
                    if (id_list[i].equals(reporter)) {
                        // 메일 발송 횟수 증가
                        answer[i]++; 
                        break; 
                    }
                }
            }
            
            // ---------
        }
        
        return answer;
    }
}
