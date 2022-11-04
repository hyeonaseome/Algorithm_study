package silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_실버2_5619_세번째 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		String[] numbers = new String[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = in.readLine();
		}
		
		

		sb.append("\n");

		System.out.println(sb);
	}
}
