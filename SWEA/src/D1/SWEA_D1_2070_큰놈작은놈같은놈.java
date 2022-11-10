package D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D1_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String[] split = in.readLine().split(" ");
			
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			
			if (n > m) {
				sb.append(">");
			}else if (n == m) {
				sb.append("=");
			}else {
				sb.append("<");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}
}
