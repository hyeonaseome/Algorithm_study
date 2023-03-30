package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA_D3_2930_힙 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+ t + " ");
			
			int N = Integer.parseInt(in.readLine()); // N: 수행할 연산수
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			String[] split;
			
			for (int i = 0; i < N; i++) {
				split = in.readLine().split(" ");
				
				switch (split[0]) {
				case "1": // 연산 1. 자연수 x를 삽입
					pq.add(Integer.parseInt(split[1]) * -1);
					break;
				case "2": // 연산 2. 최대 힙의 루트 노드의 키값을 출력하고, 해당 노드를 삭제
					if (pq.isEmpty()) sb.append(-1);
					else sb.append(pq.poll() * -1);
					sb.append(" ");
					break;
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
