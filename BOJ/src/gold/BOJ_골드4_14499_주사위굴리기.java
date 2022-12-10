package gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_골드4_14499_주사위굴리기 {
	// 동, 서, 북, 남
	// 우, 좌, 상, 하
	private static int[] dx = {0, 0, 0, -1, 1};
	private static int[] dy = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20), 
		// 주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1),
		// 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int x = Integer.parseInt(split[2]);
		int y = Integer.parseInt(split[3]);
		int k = Integer.parseInt(split[4]);
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int[] dice = new int[6];
		split = in.readLine().split(" "); // 명령
		for (int i = 0; i < k; i++) {
			int com = Integer.parseInt(split[i]);
			int testX = x + dx[com];
			int testY = y + dy[com];
			
			//주사위는 지도의 바깥으로 이동 X
			if ( !(0 <= testX && testX < N && 0 <= testY && testY < M)) continue;
			switch (com) {
			case 1:
				moveEast(dice);
				break;
			case 2:
				moveWest(dice);
				break;
			case 3:
				moveNorth(dice);
				break;
			case 4:
				moveSouth(dice);
				break;
			}
			// 이동한 칸에 쓰여 있는 수가 0이면, 
			// 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된
			if (map[testX][testY] == 0) {
				map[testX][testY] = dice[5];
			}
			
			// 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 
			// 칸에 쓰여 있는 수는 0이 된다
			else {
				dice[5] = map[testX][testY];
				map[testX][testY] = 0;
			}
			sb.append(dice[0]).append("\n");
			x = testX;
			y = testY;
			
		}

		System.out.println(sb);
	}

	private static void moveSouth(int[] dice) {
		int temp = dice[1];
		dice[1] = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[5];
		dice[5] = temp;
	}

	private static void moveNorth(int[] dice) {
		int temp = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[4];
		dice[4] = temp;
	}

	private static void moveEast(int[] dice) {
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = dice[3];
		dice[3] = temp;
	}

	private static void moveWest(int[] dice) {
		int temp = dice[2];
		dice[2] = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[5];
		dice[5] = temp;
	}
}
