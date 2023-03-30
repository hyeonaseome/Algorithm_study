package D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA_D2_1288_새로운불면증치료법 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			int N = Integer.parseInt(in.readLine()); // (1 ≤ N ≤ 10^6)
			
			int flag = 0;
			
			int copyN = N;
			
			while(copyN / 10 > 0) {
				copyN /= 10;
				int mod = copyN % 10;
				
				flag |= (1 << mod) ;
				
				System.out.println(flag);
			}
			
			System.out.println(copyN);
		}
		
	}
}
