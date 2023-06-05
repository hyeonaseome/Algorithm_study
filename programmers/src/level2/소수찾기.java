package level2;

import java.util.*;

class 소수찾기 {
    
    static int N, R, totalCnt;
    static String publicNumbers;
	static char[] makeNum;
	static boolean[] isSeLected;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        publicNumbers = numbers;
        N = numbers.length();
		totalCnt = 0;
        set = new HashSet<>();
        
        for (int i = 1; i <= N; i++) {
            R = i;
            makeNum = new char[R];
            isSeLected = new boolean[N];
            perm(0);
        }
        
        
        int answer = set.size();
    
        return answer;
    }
    
    private static void perm(int cnt) {		
		if (cnt == R) {
            int resultNum = Integer.parseInt(String.valueOf(makeNum));
            if (resultNum > 1 && isPrimeNumber(resultNum)) {
                set.add(resultNum);
            }
			return;
		}
		
		// 가능한 모든 수에 대해 시도 (input 배열의 모든 수 시도)
		for (int i = 0; i < N; i++) {  // 선택지
			
			// 시도하는 수가 선택되었는지 판단
			if(isSeLected[i]) continue;
		
			// 선택되지 않았다면 수를 사용
			makeNum[cnt] = publicNumbers.charAt(i);
			isSeLected[i] = true;
			
			// 다음 수 뽑으로 가기
			perm(cnt+1);
			
			// 사용했던 수에 대한 선택 되돌리기
			isSeLected[i] = false;		
		}
		
	}
    
    // 소수 판별 함수
    public static boolean isPrimeNumber(int x) {
        // 2부터 x의 제곱근까지의 모든 수를 확인
        for (int i = 2; i < (int) Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}