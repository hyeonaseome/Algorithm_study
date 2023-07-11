package level2;

import java.util.*;
class 귤고르기 {
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> entryList = new LinkedList<>(map.values());
        
        entryList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        for(Integer entry : entryList){            
            if ( 0 >= k)
                break;
            
            k -= entry;
            answer++;
        }
        
        return answer;
    }
}