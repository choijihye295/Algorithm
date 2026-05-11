// https://school.programmers.co.kr/learn/courses/30/lessons/12909

class Solution {
    boolean solution(String s) {
        int open = 0;
        int len = s.length();

        //괄호는 짝수여야함 (짝이 맞아야하기 때문)
        if (len % 2 != 0) return false;

        //열린괄호면 ++, 닫힌괄호 만나면 -- > 최종적으로 0이 되야함.
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                open--;
            }
            //닫힌괄호 먼저 나오면 음수가 되니까 false
            if (open < 0) return false;
        }

        return open == 0;
    }
}
