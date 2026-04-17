// https://school.programmers.co.kr/learn/courses/30/lessons/42576


import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        //가나다 정렬 -> 달라지면 참가자가 완주 못한거
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }

}
