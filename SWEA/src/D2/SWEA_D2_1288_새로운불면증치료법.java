package D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA_D2_1288_새로운불면증치료법 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			int N = Integer.parseInt(in.readLine()); // N (1 ≤ N ≤ 10^6)
			
			Set<Character> set = new HashSet<Character>();
			int k = 0;
			String newN = "";
			
			while (true) {
				k += 1;
				newN = Integer.toString(N * k);
				for (int i = 0; i < newN.length(); i++) {
					set.add(newN.charAt(i));
				}
				if (set.size() == 10) break;
			}
			
			sb.append(N * k).append("\n");
			


		}
		System.out.println(sb);
	}
}
