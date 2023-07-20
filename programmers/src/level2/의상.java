package level2;

import java.util.HashMap;
import java.util.Map;

class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String clothType = cloth[1];
            map.put(clothType, map.getOrDefault(clothType, 0) + 1);
        }
        
        for (int value : map.values()) {
            answer *= (value + 1);
        }
        answer--;
        
        return answer;
    }
}