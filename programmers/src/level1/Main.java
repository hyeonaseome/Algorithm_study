package level1;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		
		Solution sol = new Solution();
		String answer = Arrays.toString(sol.solution(numbers));
		System.out.println("answer: "+ answer);
	}
}
