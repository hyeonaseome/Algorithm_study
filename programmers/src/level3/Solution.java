package level3;

import java.util.Arrays;

class Solution {

    public int solution(String S) {
        // 상태 저장
        int[] count = new int[5];
        
        int maxCount = 0;
        
        for (int i = 0; i < S.length(); i++) {
        	
        	if ( S.charAt(i) == '<') {
        		if (count[3] > 0) { //이전에 > 가 있었다면
        			// 최종 결과 결산
        			
        			System.out.println(Arrays.toString(count));
        			int start = count[0] + count[1];
        			int end = count[3] + count[4];
        			
        			int maxStartEnd = Math.max(start, end);
        			int minStartEnd = Math.min(start, end);
        			
        			int diff = maxStartEnd - minStartEnd;
        			
        			int localAnswer = 0;
        			
        			if (diff > 0) {
        				if (count[2] >= diff) {
        					localAnswer = (start + count[2] + end) / 2;
        					System.out.println("조건 1");
        				}else {
        					localAnswer = Math.min(minStartEnd + count[2], maxStartEnd);
        					System.out.println("조건 2");
        				}
        				
        			} else {
        				localAnswer = (start + count[2] + end) / 2;
        				System.out.println("조건 3");
        			}
        			System.out.println(localAnswer);
        			
        			
        			maxCount = Math.max(maxCount, localAnswer);
        			
        			
        			// 새로운 시작
        			int lastQCnt = count[4];
        			count = new int[5];
        			count[0] = lastQCnt;
        			count[1]++;
        		} else {
        			count[1]++;
        		}
        		
        	} else if (S.charAt(i) == '?') {
        		if (count[1] == 0) {
        			count[0]++;
        		} else if (count[1] > 0 && count[3] == 0) {
        			count[2]++;
        		}
        		else if (count[1] > 0 && count[3] > 0) {
        			count[4]++;
        		}
        		
        	} else if (S.charAt(i) == '>') {
        		count[3]++;
        	} 

        }
        System.out.println(Arrays.toString(count));
        
        int start = count[0] + count[1];
		int end = count[3] + count[4];
		
		int maxStartEnd = Math.max(start, end);
		int minStartEnd = Math.min(start, end);
		
		int diff = maxStartEnd - minStartEnd;
		
		int localAnswer = 0;
		
		if (diff > 0) {
			if (count[2] >= diff) {
				localAnswer = (start + count[2] + end) / 2;
				System.out.println("조건 1");
			}else {
				localAnswer = Math.min(minStartEnd + count[2], maxStartEnd);
				System.out.println("조건 2");
			}
			
		} else {
			localAnswer = (start + count[2] + end) / 2;
			System.out.println("조건 3");
		}
		System.out.println(localAnswer);
		
		
		maxCount = Math.max(maxCount, localAnswer);
        
        return maxCount * 2;
    }

	
}
