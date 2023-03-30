package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA_D3_3304_최장공통부분수열 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			

			String[] split = in.readLine().split(" ");
			int answer = LCS(split[0], split[1]);			
			
			
			
			sb.append("#"+ t + " ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static int LCS(String string, String string2) {
		int[][] DP = new int[1001][1001];
		
		for (int i = 1; i <= string2.length(); i++) {
			for (int j = 1; j <= string.length(); j++) {
				if(string2.charAt(i-1) == string.charAt(j-1)) {
					DP[i][j] = DP[i-1][j-1] + 1;
				}
				else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
		
		return DP[string2.length()][string.length()];
	}
}
