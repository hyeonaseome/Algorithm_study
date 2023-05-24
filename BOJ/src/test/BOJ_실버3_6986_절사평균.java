package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

public class BOJ_실버3_6986_절사평균 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);

		BigDecimal[] scores = new BigDecimal[N];
		BigDecimal total = new BigDecimal("0");

		for (int i = 0; i < N; i++) {
			scores[i] = new BigDecimal(in.readLine());
			total = total.add(scores[i]);
		}

		Arrays.sort(scores);
		BigDecimal avg1 = total;

		for (int i = 0; i < K; i++) {
			avg1 = avg1.subtract(scores[i]);
			avg1 = avg1.subtract(scores[N - 1 - i]);
		}

		BigDecimal adding = scores[K].add(scores[N - 1 - K]);
		adding = adding.multiply(new BigDecimal(K));
		BigDecimal avg2 = avg1.add(adding);
		sb.append(avg1.divide(new BigDecimal((N - 2 * K)), 2, BigDecimal.ROUND_HALF_UP));
		sb.append("\n");
		sb.append(avg2.divide(new BigDecimal(N), 2, BigDecimal.ROUND_HALF_UP));

		System.out.println(sb);
	}
}
