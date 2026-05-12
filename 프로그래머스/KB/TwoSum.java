//https://leetcode.com/problems/two-sum/submissions/2000949039/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //완전탐색 O(n^2)
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]<target){
        //         for(int j=i+1; j<nums.length; j++){
        //             if(nums[i]+nums[j] == target){
        //                 return new int[]{i, j};
        //             }
        //         }
        //     } else break;
        // }
        // return new int[]{};

        //해시맵 사용 
        HashMap<Integer, Integer> memo = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int need = target - nums[i];
            if(memo.containsKey(need)){
                return new int[] {memo.get(need), i};
            }
            memo.put(nums[i], i);
        }
        return new int[]{};
    }
}
