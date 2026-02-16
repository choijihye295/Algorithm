#https://school.programmers.co.kr/learn/courses/30/lessons/42586

def solution(progresses, speeds):
    answer = []
    days = []
    
    # 필요한 일수 계산
    for i in range(len(progresses)):
        remaining = 100 - progresses[i] #남은 작업량
        day = remaining // speeds[i] #필요한 일수
        
        if remaining % speeds[i] != 0:
            day+=1
        
        days.append(day)
    
    count = 1 #기본적으로 1개는 배포함
    max_day = days[0] #앞선 작업 끝나야 배포 가능
    
    
    # 배포 일수 계산
    for i in range(1, len(days)):
        if days[i] <= max_day: #앞선 작업과 같이 배포
            count += 1
        else:
            answer.append(count)
            count = 1 #초기화
            max_day = days[i]  #새로운 배포그룹
    
    answer.append(count) #마지막 배포 추가
    
    return answer
