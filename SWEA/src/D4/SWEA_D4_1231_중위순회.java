package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_D4_1231_중위순회 {

	private static int N; // 트리가 갖는 정점의 총 수 N (1 <= N <= 100)
	private static StringBuilder sb = new StringBuilder();
	private static char[] nodes;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = 10; // 10개의 테스트 케이스
		
		// 제약 조건
		// 트리는 완전 이진 트리 형식
		// 노드당 하나의 문자만 저장
		
		for (int t = 1; t <= T; t++) {
			sb.append("#"+ t + " ");
			N = Integer.parseInt(in.readLine()); 
			
			nodes = new char[N+1] ; // 완전 이진트리
			
			for (int i = 1; i <= N ; i++) {
				String[] split = in.readLine().split(" ");
				nodes[i] = split[1].charAt(0);
			}
			
			dfs(1);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	
	private static void dfs(int i) {
		if (i > N) return;
		
		// 왼쪽
		dfs(i * 2); 
		
		sb.append(nodes[i]);
		
		// 오른쪽
		dfs(i * 2 + 1);
		
	}
}
