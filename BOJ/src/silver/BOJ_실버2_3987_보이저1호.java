package silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_실버2_3987_보이저1호 {
	private static final char BLACKHALL = 'C';
	private static final char PLANET1 = '/';
	private static final char PLANET2 = '\\';
	
	private static int maxdirIdx, max, N, M;
	private static char[][] map;
	private static int[][] isVisited;
	
	private static final char[] dir = new char[] {' ','U','R','D','L'};
	
	private static final int[] dx = new int[] {0, -1, 0, 1, 0};
	private static final int[] dy = new int[] {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		// 1 ≤ N, M ≤ 500, N행 M열
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		// 탐사선이 있는 위치 PR, PC
		split = in.readLine().split(" ");
		// 1 ≤ PR ≤ N, 1 ≤ PC ≤ M
		int PR = Integer.parseInt(split[0]) - 1;
		int PC = Integer.parseInt(split[1]) - 1;
		
		maxdirIdx = 0;
		max = 0;
		
		for (int i = 1; i <= 4; i++) { // 4방향
			isVisited = new int[N][M]; // 매 방향마다 초기화
			int testX = PR + dx[i];
			int testY = PC + dy[i];
			int count = simulate(testX, testY, i, 1);
			if (max < count) {
				max = count;
				maxdirIdx = i;
			}
		}
		
		if(max != Integer.MAX_VALUE) {
			sb.append(dir[maxdirIdx]).append("\n").append(max);
		} else {
			sb.append(dir[maxdirIdx]).append("\n").append("Voyager");
		}
		sb.append("\n");

		System.out.println(sb);
	}
	
	private static final int[] changeP1 = new int[]{0, 2, 1, 4, 3}; 
	private static final int[] changeP2 = new int[]{0, 4, 3, 2, 1}; 
	private static int  simulate(int x, int y, int curDir, int cnt) {
		
		// 항성계를 벗어날 때
		if ( x < 0 || N <= x || y < 0 || M <= y) {
			return cnt;
		}
		
		// 같은 장소를 같은 방향으로 이동한 적이 있다면 Voyager
		if((isVisited[x][y] & (1 << curDir)) > 0) {
			return Integer.MAX_VALUE;
		}
			
		isVisited[x][y] |= 1 << curDir;
		
		switch(map[x][y]){
		case PLANET1: // 행성 /
			curDir = changeP1[curDir];
			break;
		case PLANET2: // 행성 \
			curDir = changeP2[curDir];
			break;
		case BLACKHALL:// 블랙홀일 때
			return cnt;
		}
		
		int testX = x + dx[curDir];
		int testY = y + dy[curDir];
		return simulate(testX, testY, curDir, cnt + 1);
	}
}
