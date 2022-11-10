package D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D1_2071_평균값구하기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int sum = 0; // 초기화
			
			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			double avg = sum / 10.0;
			
			sb.append(String.format("%.0f", avg)).append("\n");
		}
		System.out.println(sb);
	}
}
