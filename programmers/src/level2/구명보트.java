package level2;

/*
1 <= people.length <= 50_000

40 <= people[?] <= 240

40 <= limit <= 240

항상 모든 사람을 구출 할 수 있음

*/
import java.util.*;
class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 사람을 무게순으로 정렬
        Arrays.sort(people);
        
        int min = 0;
        for (int i = people.length -1; i >= 0; i--) {
            if (people[i]+ people[min] <= limit) {
                min++;  
            }
            answer++;
            
            if (i <= min){
                break;
            }
        }
        
        
        return answer;
    }
}