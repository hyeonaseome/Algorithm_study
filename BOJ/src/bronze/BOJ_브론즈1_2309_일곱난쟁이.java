package bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
 * 일곱 난쟁이의 키의 합이 100
 */
public class BOJ_브론즈1_2309_일곱난쟁이 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] heights = new int[9];
		Set<Integer> set = new HashSet<>();
		int totalSum = -100;
		for (int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(in.readLine());
			set.add(heights[i]);
			totalSum += heights[i];
		}
		Arrays.sort(heights);
		
		int findNum = -1;
		int findNum1 = -1;

		for (int i = 0; i < 9; i++) {
			findNum = totalSum - heights[i];
			if (heights[i] != findNum && set.contains(findNum)) {
				findNum1 = heights[i];
				break;
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (heights[i] == findNum || heights[i] == findNum1) {
				continue;
			}
			sb.append(heights[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
