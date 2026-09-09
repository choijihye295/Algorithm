import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("======================");
        System.out.println("<<배열>>");

        //배열
        int[] arr = {3,1,2};
        Arrays.sort(arr); // 정렬

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.remove(list.size() - 1);

         System.out.println("======================");
        System.out.println("<<해시맵>>");

        //해시맵 : 이름표key를 붙여서 값을 저장하는 상자
        Map<String, Integer> map = new HashMap<>(); //key:String, value:Integer
        //put()은 저장
        map.put("apple",1); //apple이라는 키에 1 저장
        System.out.println(map); // {apple=1} 출력됨.
        // get()은 가져오기
        System.out.println(map.get("apple")); // 1출력됨

        //getOrDefault는 키의 값을 가져오는데 없으면 기본값을 주는거
        System.out.println(map.getOrDefault("apple", 0)); // 1 출력됨
        System.out.println(map.getOrDefault("banana", 0)); // 0 출력됨

        // 응용
        map.put("apple",map.getOrDefault("apple", 0)+1 );
        //위 코드는 결국 map.put("apple", 2); 랑 같음
        System.out.println(map.get("apple"));

        System.out.println("======================");
        System.out.println("<<집합>>");
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        System.out.println("======================");
        System.out.println("<<스택 / 큐>>");
        Deque<Integer> dq = new ArrayDeque<>();

        dq.push(10); //스택 넣기
        dq.pop();

        dq.offer(20); //큐 넣기
        dq.poll(); //큐 앞에서 빼기

    }
}
