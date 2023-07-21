package level2;

import java.util.*;

class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i< discount.length; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if (i >= 10)
                map.put(discount[i - 10], map.getOrDefault(discount[i - 10], 0) - 1);
            
            boolean isPossible = true;
            for (int j = 0; j < want.length; j++) {
                if (map.getOrDefault(want[j], 0) < number[j]) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                answer++;
            }
        }
        return answer;
    }
}