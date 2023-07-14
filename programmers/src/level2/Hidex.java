package level2;

import java.util.*;

class Hidex {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);

        int answer = 0;
        
        for (int i = 0; i < citations.length; i++){

            if(citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }
        
        return answer;
    }
}