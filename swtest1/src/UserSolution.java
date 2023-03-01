import java.util.Arrays;

/**
 * @author SSAFY
 * 
 * 제약 사항
 * 1. 생각하는 수 는 4자리
 * 2. 생각하는 수는 0 부터 9까지 중복되지 않는 숫자로 이루어짐
 * 3. 생각하는 수는 0부터 시작 가능
 * 4. 각 테스트 케이스에서 query 함수의 호출한 횟수가 일정 수준 이하이고 생각하는 수와 
 *     guess 배열에 저장된 값이 일치하는 경우만 점수를 얻는다.
 * 5. 동점자인 경우 query 함수를 호출한 총 회수가 적을 수록 유리
 *
 *
 * 시나리오 1
 * 1. 일단 최대한 겹치지 않는 두 집합 을 test해본다.
 * 1234, 5678 두 집합의 ball, strike 합이 4 보다 작은 경우 9, 0 확인 필요
 * 큰 경우 필요 없음
 * 
 * 두개 중 ball, strike 합이 큰 경우를 하나 골롸 마지막 숫자를 변경해 보기
 */
class UserSolution {
    public final static int N = 4;
    public static boolean[] numbers = new boolean[10]; 
    
    static class Result {
        public int strike;                                
        public int ball;
	}

    public void doUserImplementation(int guess[]) {
        // Implement a user's implementation function
        //
        // The array of guess[] is a return array that
        // is your guess for what digits[] would be.
    	
    
//    	guess = new int[] {8,9,7,5};
    	
    	int[][] game = new int[3][2];
    	
    	// 1234 중 몇 개인지 판단
    	for (int i = 0; i < 4; i++) {
    		guess[i] = i+1;
    	}
    	
    	printGuess(guess);
    	
    	
    	
    	// 5678 중 몇 개 인지 판단
    	for (int i = 0; i < 4; i++) {
    		guess[i] = i+5;
    	}
    	
    	printGuess(guess);

    	
    	guess[0] = 1;
    	guess[1] = 2;
    	guess[2] = 3;
    	guess[3] = 9;
    	printGuess(guess);
    	
    	guess[0] = 5;
    	guess[1] = 6;
    	guess[2] = 9;
    	guess[3] = 7;
    	printGuess(guess);
    	
    	guess[0] = 5;
    	guess[1] = 9;
    	guess[2] = 8;
    	guess[3] = 9;
    	printGuess(guess);
    	
    	guess[0] = 7;
    	guess[1] = 5;
    	guess[2] = 9;
    	guess[3] = 8;
    	printGuess(guess);
    	
    	guess[0] = 9;
    	guess[1] = 8;
    	guess[2] = 7;
    	guess[3] = 5;
    	printGuess(guess);
    	
    	guess[0] = 8;
    	guess[1] = 9;
    	guess[2] = 7;
    	guess[3] = 5;
    	printGuess(guess);
    	

    
    }

	private void printGuess(int[] guess) {
		// TODO Auto-generated method stub
		System.out.println("---------------------");
    	System.out.println(Arrays.toString(guess));
    	Solution.Result query = Solution.query(guess);
    	System.out.println("Ball:" + query.ball);
    	System.out.println("Strike: "+query.strike);
    	System.out.println("---------------------");
	}
}
