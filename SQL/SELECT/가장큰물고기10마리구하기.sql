-- https://school.programmers.co.kr/learn/courses/30/lessons/298517

-- 코드를 작성해주세요

select ID, LENGTH
from FISH_INFO
order by LENGTH desc, ID asc
limit 10; -- order by로 정렬 후 상위 n개 가져오기
