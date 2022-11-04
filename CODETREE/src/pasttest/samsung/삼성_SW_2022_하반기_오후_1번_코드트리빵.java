package pasttest.samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 삼성_SW_2022_하반기_오후_1번_코드트리빵 {

	private static final int SPACE = 0;
	private static final int BASECAMP = 1;
	private static final int CANTGO = 2;

	// 상, 좌, 우, 하
	private static final int[] dx = { -1, 0, 0, 1 };
	private static final int[] dy = { 0, -1, 1, 0 };

	private static int n, m;
	private static int[][] map;
	private static Point[] storeLoc; // t번 사람이 도착해야할 상점 위치
	// private static Point[] person; // 사람이 도착할 위치
	private static Map<Integer, Point> person;

	// baseCamp 위치
	private static Map<Integer, Point> baseCamp; // 사용가능한 baseCamp 위치 저장

	// 격자 내 사람

	private static class Point {
		int x;
		int y;

		public Point() {
			this.x = -1;
			this.y = -1;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken()); // 격자의 크기 2 ≤ n ≤ 15
		m = Integer.parseInt(st.nextToken()); // 사람의 수 1<=m <= min(n^2, 30)

		map = new int[n + 1][n + 1];

		int baseCampCnt = 0;
		baseCamp = new TreeMap<>();

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == BASECAMP) {
					baseCamp.put(++baseCampCnt, new Point(i, j));
				}
			}
		}

		storeLoc = new Point[m + 1];
		person = new HashMap<>();
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(in.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			storeLoc[i] = new Point(x, y);
		}

		int t = 1; // 분
		while (true) {
			if (t > m && person.isEmpty()) {
				break;
			}
			// 격자내 사람이 있을 때
			if (!person.isEmpty()) {
				// 1. 편의점으로 이동
				moveInMap();
				// 2. 해당 편의점에 도착했을 때
				arrivalStore();
			}

			// 3. 현재시간 t, t<=m 만족시 t 번사람은 베이스 캠프에 이동
			movetobase(t);
			t++;

		}
		sb.append(t - 1);
		System.out.println(sb);
	}

	private static void moveInMap() {
		for (int key : person.keySet()) {
			// 최단 거리 방향 구하기
			int dir = bfs(key);

			// 최단 거리 방향으로 1칸 움직이기
			person.get(key).x += dx[dir];
			person.get(key).y += dy[dir];

		}
	}

	private static void arrivalStore() {
		Queue<Integer> queue = new ArrayDeque<>();
		for (int key : person.keySet()) {
			if (person.get(key).x == storeLoc[key].x && person.get(key).y == storeLoc[key].y) { // 편의점 도착
				queue.add(key);
			}
		}

		while (!queue.isEmpty()) {
			int key = queue.poll();
			person.remove(key); // 움직이지 않는 사람
			// 해당 편의점 이용 X
			map[storeLoc[key].x][storeLoc[key].y] = CANTGO;
		}
	}

	private static int bfs(int key) {
		Point point = person.get(key);
		boolean[][] visited = new boolean[n + 1][n + 1];
		Queue<Point> queue = new ArrayDeque<>();
		Queue<Queue<Integer>> dirqueue = new ArrayDeque<>();
		queue.add(point);
		visited[point.x][point.y] = true;
		dirqueue.add(new ArrayDeque<>());

		int targetX = storeLoc[key].x;
		int targetY = storeLoc[key].y;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point curPoint = queue.poll();
				Queue<Integer> curQueue = dirqueue.poll();
				int x = curPoint.x;
				int y = curPoint.y;

				// 기저 조건
				if (x == targetX && y == targetY) {
					return curQueue.poll();
				}

				for (int d = 0; d < 4; d++) {
					int testX = x + dx[d];
					int testY = y + dy[d];
					if (!(0 < testX && testX <= n && 0 < testY && testY <= n))
						continue; // 범위 밖
					if (map[testX][testY] == CANTGO)
						continue; // 갈 수 없는 곳
					if (visited[testX][testY])
						continue;// 방문했던 곳

					queue.add(new Point(testX, testY));
					visited[testX][testY] = true; // 방문처리
					Queue<Integer> newQueue = new ArrayDeque<>(curQueue);
					newQueue.add(d);
					dirqueue.add(newQueue);
				}
			}
		}
		return 0;
	}

	private static void movetobase(int t) {
		if (t > m)
			return;

		// t<=m 만족시 t 번사람은 베이스 캠프에 이동
		// 최단 거리의 baseCamp 구하기
		Point mindisBaseCamp = bfsBasecamp(t);

		// t번 사람이 베이스 캠프로 이동
		person.put(t, new Point(mindisBaseCamp.x, mindisBaseCamp.y));

		// 다른 사람들은 해당 베이스 캠프가 있는 칸을 지나갈 수 없게
		map[mindisBaseCamp.x][mindisBaseCamp.y] = CANTGO;
	}

	private static Point bfsBasecamp(int t) {
		Point point = storeLoc[t];
		boolean[][] visited = new boolean[n + 1][n + 1];
		Queue<Point> queue = new ArrayDeque<>();

		queue.add(point);
		visited[point.x][point.y] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point curPoint = queue.poll();
				int x = curPoint.x;
				int y = curPoint.y;

				// 기저 조건
				if (map[x][y] == BASECAMP) {
					return curPoint;
				}

				for (int d = 0; d < 4; d++) {
					int testX = x + dx[d];
					int testY = y + dy[d];
					if (!(0 < testX && testX <= n && 0 < testY && testY <= n))
						continue; // 범위 밖
					if (map[testX][testY] == CANTGO)
						continue; // 갈 수 없는 곳
					if (visited[testX][testY])
						continue;// 방문했던 곳

					queue.add(new Point(testX, testY));
					visited[testX][testY] = true; // 방문처리
				}
			}
		}
		return new Point(-1, -1);
	}

	private static int getDis(int x1, int y1, int storeX, int storeY) {
		return Math.abs(x1 - storeX) + Math.abs(y1 - storeY);
	}
}
