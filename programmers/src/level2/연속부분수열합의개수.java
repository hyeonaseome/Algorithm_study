package level2;

import java.util.Set;
import java.util.HashSet;

class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= elements.length; i++) { // 수열의 길이
            int sum = 0;
            // 초기 값
            for (int j = 0; j < i; j++) {
                sum += elements[j];
            }
            set.add(sum);
            
            for (int j = 1; j < elements.length;j++) { // 수열의 시작 위치
                sum = sum - elements[j-1] + elements[(j + i - 1) % elements.length];
                set.add(sum);
            }
            
        }
        
        return set.size();
    }
}