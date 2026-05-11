// https://leetcode.com/problems/valid-parentheses/submissions/2000432326/

class Solution {
    public boolean isValid(String s) {
        boolean answer = true;
        int len = s.length();
        if(len%2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { //닫힌괄호
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if(c == ')' && top == '(' || c==']' && top=='[' || c=='}' && top=='{' ){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
