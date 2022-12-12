package silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_실버3_3085_사탕게임 {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine()); // 보드의 크기 N
		
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String readLine = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = readLine.charAt(j);
			}
		}
		
		int answer = 0;
		// 좌 우로 인접한 두 칸을 변경하기..!
		label:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				if (map[i][j] == map[i][j + 1]) continue;
				char temp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = temp;
				
				// 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)
				// 가로 확인
				// answer == 0일 때 모두 찾기
				int maxCnt = checkRow(N, map);
				answer = Math.max(maxCnt, answer);
				if (answer == N) {
					break label;
				}
				
				// 세로 확인
				maxCnt = checkColumn(N, map, maxCnt);
				answer = Math.max(maxCnt, answer);
				if (answer == N) {
					break label;
				}
				
				// 다시 원상태로
				map[i][j + 1] = map[i][j];
				map[i][j] = temp;
			}
		}
		
		if (answer != N) {
			label:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N-1; j++) {
						if (map[j][i] == map[j + 1][i]) continue;
						char temp = map[j][i];
						map[j][i] = map[j + 1][i];
						map[j + 1][i] = temp;
						
						// 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)
						// 가로 확인
						// answer == 0일 때 모두 찾기
						int maxCnt = checkRow(N, map);
						answer = Math.max(maxCnt, answer);
						if (answer == N) {
							break label;
						}
						
						// 세로 확인
						maxCnt = checkColumn(N, map, maxCnt);
						answer = Math.max(maxCnt, answer);
						if (answer == N) {
							break label;
						}
						
						// 다시 원상태로
						map[j + 1][i] = map[j][i];
						map[j][i] = temp;
					}
				}
		}
		sb.append(answer);

		System.out.println(sb);
	}

	private static int checkColumn(int N, char[][] map, int maxCnt) {
		for (int k = 0; k < N; k++) {
			int cnt = 1;
			char ckColor = map[0][k];
			for (int k2 = 1; k2 < map.length; k2++) {
				if (map[k2][k] == ckColor) {
					cnt++;
				}
				else {
					maxCnt = Math.max(maxCnt, cnt);
					cnt = 1;
					ckColor = map[k2][k];
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		return maxCnt;
	}

	private static int checkRow(int N, char[][] map) {
		int maxCnt = 0;
		for (int k = 0; k < N; k++) {
			int cnt = 1;
			char ckColor = map[k][0];
			for (int k2 = 1; k2 < map.length; k2++) {
				if (map[k][k2] == ckColor) {
					cnt++;
				}
				else {
					maxCnt = Math.max(maxCnt, cnt);
					cnt = 1;
					ckColor = map[k][k2];
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		return maxCnt;
	}
}
