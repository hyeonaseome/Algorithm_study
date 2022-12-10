package bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 총 N개의 시험장
 * 각각의 시험장마다 응시자들
 *  
 * 감독관은 총감독관과 부감독관으로 두 종류
 */

public class BOJ_브론즈2_13458_시험감독 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 시험장의 개수 N(1 ≤ N ≤ 1,000,000)
		int N = Integer.parseInt(in.readLine());
		// 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)
		int[] A = new int[N];
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(split[i]);
		}
		// B와 C가 주어진다. (1 ≤ B, C ≤ 1,000,000)
		split = in.readLine().split(" ");
		long B = Integer.parseInt(split[0]);
		long C = Integer.parseInt(split[1]);
		
		long answer = 0;
		for (int i = 0; i < N; i++) {
			// 총 감독관이 존재
			long answerB = (A[i] - B) / C + 1;
			if (A[i] - B < 0) {
				answerB = 1;
			}
			else {
				if ((A[i] - B) % C > 0) {
					answerB += 1;
				}
			}
			
			answer += answerB;
		}
		
		sb.append(answer);
		System.out.println(sb);
	}
}
