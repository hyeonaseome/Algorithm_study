package D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D1_2058_자릿수더하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String readLine = in.readLine();
		
		int sum = 0;
		for (int i = 0; i < readLine.length(); i++) {
			sum += readLine.charAt(i) - '0';
		}
		System.out.println(sum);
		
	}
}
