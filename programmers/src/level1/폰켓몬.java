package level1;

import java.util.*;

class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count++);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        int numLen = nums.length/2 ;
                
        answer = map.size() > numLen ? numLen : map.size();
        
        return answer;
    }
}
