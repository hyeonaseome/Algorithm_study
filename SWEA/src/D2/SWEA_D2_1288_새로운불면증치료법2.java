package D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA_D2_1288_새로운불면증치료법2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		int visitedAll = (1 << 10) - 1; // 모든 숫자가 나타남
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			int N = Integer.parseInt(in.readLine()); // N (1 ≤ N ≤ 10^6)
			
			int visited = 0;
			int count = 0;
			for (count=1;;count++) {
				char[] arr = String.valueOf(N * count).toCharArray();
				// N*count 숫자 -> String.valueOf (문자열) -> toCharArray()로 변형
				
				for (char c: arr) {
					int num = c - '0'; // char to int
					visited = visited | (1 << num); // 등장하면 bit을 1로 변경
				}
				if (visited == visitedAll) break;  // 모든 숫자 등장(방문)시 끝
			}
			sb.append(N * count).append("\n");

		}
		System.out.println(sb);
	}
}
