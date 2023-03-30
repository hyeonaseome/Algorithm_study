package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA_D3_3282_01Knapsack {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+ t + " ");
			
			String[] split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]); // N: 물건의 개수
			int K = Integer.parseInt(split[1]); // K: 가방의 부피
			
			int[][] vc = new int[N + 1][2];
			for (int i = 1; i<= N; i++) {
				split = in.readLine().split(" ");
				vc[i][0] = Integer.parseInt(split[0]); // v: 부피
				vc[i][1] = Integer.parseInt(split[1]); // c: 가치
			}
			
			
			int[][] dp = new int[N + 1][K + 1];
			
			for (int i = 1; i<= N; i++) {
				for (int j = 1; j <= K; j++) {
					if (vc[i][0]  > j) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(vc[i][1] + dp[i-1][ j - vc[i][0]], dp[i-1][j]);
					}
				} 
			}
			

			sb.append(dp[N][K]);
			
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
