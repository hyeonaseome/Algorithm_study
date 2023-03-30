package D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 *  N의 배수 번호인 양을 세기
 *  이전에 셌던 번호들의 각 자리수에서 
 *  0에서 9까지의 모든 숫자를 보는 것은 
 *  최소 몇 번 양을 센 시점일까?
 */
public class SWEA_D1_1545_거꾸로출력해보아요 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		while(n>= 0) {
			System.out.print(n-- + " ");
		}
		
	}
}
