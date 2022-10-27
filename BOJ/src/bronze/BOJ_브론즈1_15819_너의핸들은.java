package bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_브론즈1_15819_너의핸들은 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		
		String[] handles = new String[N];
		
		for (int i = 0; i < N; i++) {
			handles[i] = in.readLine();
		}
		
		Arrays.sort(handles);
		
		sb.append(handles[I - 1]);

		System.out.println(sb);

	}
}
