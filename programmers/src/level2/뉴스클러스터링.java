package level2;

import java.util.HashMap;
import java.util.Map;

class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> set1 = new HashMap<>();
        Map<String, Integer> set2 = new HashMap<>();
        
        int intersection = 0;
        int union = 0;
        
        // str1으로 다중집합 만들기
        for (int i = 0; i < str1.length() -1; i++){
            String subStr = str1.substring(i, i+ 2);
            if (subStr.matches("^[a-zA-Z]*$")) {
                set1.put(subStr, set1.getOrDefault(subStr, 0) + 1);
            }
        }
        // str2로 다중집합 만들기
        for (int i = 0; i < str2.length() -1; i++){
            String subStr = str2.substring(i, i+ 2);
            if (subStr.matches("^[a-zA-Z]*$")) {
                set2.put(subStr, set2.getOrDefault(subStr, 0) + 1);
            }
                
        }
        
        // 두 다중 집합이 모두 공집합일 때
        if (set1.isEmpty() && set2.isEmpty()) {
            return 65536;
        }
        
        Map<String, Integer> unionSet = new HashMap<>();
        unionSet.putAll(set1);
        unionSet.putAll(set2);
        
        // 교집합과 차집합 계산
        for(Map.Entry<String, Integer> e1 : set1.entrySet()){
            if (set2.containsKey(e1.getKey())) {
                intersection += Math.min(e1.getValue(), set2.get(e1.getKey()));
                unionSet.put(e1.getKey(), Math.max(e1.getValue(), set2.get(e1.getKey())));
            }
        }
        
        for (Integer value : unionSet.values()) {
            union += value;
        }
        
        return (int) (intersection * 65536 / union);
    }
}