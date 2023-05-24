package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String S) {
        int answer = 0;
        
        // 현재 알파벳의 개수가 홀수 인지 확인
        boolean[] alphabetIsOdd = new boolean[26];
        
        for (int i = 0; i< S.length(); i++) {
        	int alphabet = S.charAt(i) - 'a';
        	System.out.println(alphabet);
        	
        	if (alphabetIsOdd[alphabet]) { // 현재 홀수개
        		alphabetIsOdd[alphabet] = false; // 짝수개로 변경
        		answer--;
        	} else { // 현재 짝수개
        		alphabetIsOdd[alphabet] = true; // 홀수 개로 변경
        		answer++;
        	}
        	
        }
        
        
        
        return answer;
    }

	
}
