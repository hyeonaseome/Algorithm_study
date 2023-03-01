package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	
	private int[] Numbers;
	
	private Set set;
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Numbers = numbers;
        set = new HashSet<Integer>();
        
        perm2(0, 0, 0);
       
        Object[] array = set.toArray();
        
        answer = new int[set.size()];
        
        for (int i = 0; i < set.size(); i++) {
        	answer[i] = (Integer) array[i];
        }
        
        Arrays.sort(answer);
        
        return answer;
    }

	private void perm2(int cnt, int start, int sum) {
		
		// 종료 조건
		if (cnt == 2) {
			set.add(sum);
			return;
		}
		
		for (int i = start; i < Numbers.length; i++) {

			perm2(cnt + 1, i+1,  sum + Numbers[i]);
		}
	}
}
