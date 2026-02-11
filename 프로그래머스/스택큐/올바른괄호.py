#https://school.programmers.co.kr/learn/courses/30/lessons/12909

def solution(s):
    stack = []
    
    for ch in s:
        if ch == '(': #여는 괄호라면 스택에 넣음
            stack.append(ch)
        elif ch == ')': #닫는 괄호라면 스택의 마지막 괄호와 짝이 맞는지 비교
            if not stack: #스택이 비어있는 경우
                return False
            
            top = stack.pop() #스택에서 꺼냄
            #꺼낸게 이게 아니라면 짝 안맞는 거
            if top != '(' :
                return False

    #모든 순회가 끝나면 스택 비어있어야함
    return len(stack) == 0
