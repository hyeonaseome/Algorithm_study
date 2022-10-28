package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;

public class BOJ_브론즈5_1008_AB {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		BigDecimal  A = new BigDecimal(split[0]);
		BigDecimal  B = new BigDecimal(split[1]);
		BigDecimal  C = A.divide(B, MathContext.DECIMAL128);
		

		System.out.println(C);
	}
}
