//https://school.programmers.co.kr/learn/courses/30/lessons/12906

#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int len = arr.size(); //길이 구하기
    
    //answer.push_back(arr[i]); 
    //answer.pop_back();
    
    answer.push_back(arr[0]); //첫 요소 넣어두기
    
    for(int i=1; i<len; i++){
        if(arr[i]!=arr[i-1]){ //현재요소와 이전요소 비교해서 다르면 넣기
            answer.push_back(arr[i]); 
        }
    
    }
    
    return answer;
}
