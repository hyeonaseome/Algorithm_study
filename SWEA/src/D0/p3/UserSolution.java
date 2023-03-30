package D0.p3;

import java.util.HashMap;
import java.util.Map;

/**
 *  바이러스 감염자의 동선을 추적하는 프로그램을 개발
 *  
 *  10,000 행과 10,000 열의 칸으로 구분된 지도를 이용한다.

지도 상에는 방문 가능한 장소가 추가되거나 삭제될 수 있다.

 

감염자의 이동 경로는 처음 이동을 시작한 장소와 이후 움직인 방향의 목록으로 주어진다.

감염자는 원래 있던 장소에서 출발하여 주어지는 이동 방향을 향해 가장 먼저 만나는 방문 가능한 장소까지 이동한다.

이동은 주어진 움직인 방향의 개수만큼 반복한다.

감염자의 동선이 확정된 이후, 감염자가 방문한 장소들은 소독이 되기 전까지 방문이 금지된다.

 

감염자가 방문했던 장소들의 소독이 완료되면, 그 이후부터는 다시 방문 가능한 장소가 된다.

 

아래 API 설명을 참조하여 각 함수를 구현하라.

※ 아래 함수 signature는 C/C++에 대한 것으로 다른 언어에 대해서는 제공되는 Main과 User Code를 참고하라.
 *
 */

class UserSolution {
	
	private static int[][] map;
	private static int N = 10000;
	
	// 상, 상우, 우, 우하, 하, 하좌, 좌, 좌상
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	private static class Point {
		int x;
		int y;
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	private static Map<Integer, Point> places;
	
	

	void init() {
// 각 테스트 케이스의 처음에 호출된다.

//테스트 케이스 시작 시 어떠한 장소나 감염자 정보도 없다.
		
		map = new int[N][N];
		places = new HashMap<>();
	}

	
	/**
	 * r 행 c 열에 방문 가능한 장소 pID 를 추가한다.
	 * @param pID: 추가할 장소의 ID (1 ≤ pID ≤ 50,000)
	 * @param r: 장소가 추가될 행 (0 ≤ r ≤ 9,999)
	 * @param c: 장소가 추가될 열 (0 ≤ c ≤ 9,999)
	 * 
	 * r 행 c 열에 방문 가능한 장소 pID 를 추가한다.
	 * 각 테스트 케이스에서 addPlace() 함수로 불리는 pID는 1부터 시작하여 1씩 증가한다.
	 * r 행 c 열에는 다른 장소가 존재하지 않음이 보장된다.
	 * 
	 * 기존의 장소가 삭제된 자리에 다시 추가되는 경우는 있을 수 있다.
	 * 모든 행, 열 또는 대각선에 일렬로 존재하는 장소는 10개 이하로 주어진다.
	 */
	void addPlace(int pID, int r, int c) {
		map[r][c] = pID;
		places.put(pID, new Point(r, c));
	}

	/**
	 * pID 장소를 삭제한다.
	 * pID 는 addPlace() 함수를 통해 추가된 값만 주어진다.
	 * pID 는 removePlace() 함수를 통해 이전에 삭제되지 않았음이 보장된다.
	 * 
	 * @param pID : 삭제할 장소의 ID (1 ≤ pID ≤ 50,000)
	 */
	void removePlace(int pID) {

	}

	/**
	 * 감염자 uID 가 이동한 동선이 주어진다.
	 * 각 테스트 케이스에서 contactTracing() 함수로 불리는 uID는 1부터 시작하여 1씩 증가한다.
	 * 
	 * moveInfo[0] 에는 감염자가 가장 처음 방문한 장소의 pID가 주어진다.
	 * moveInfo[1] ~ moveInfo[visitNum – 1] 에는 감염자가 이동한 방향이 0 ~ 7의 숫자로 주어진다.
	 * 
	 * @param uID 감염자의 ID (1 ≤ uID ≤ 1,000)
	 * @param visitNum  감염자가 방문한 장소의 수 (2 ≤ visitNum ≤ 100)
	 * @param moveInfo:
         moveInfo[0] = 이동을 시작한 장소의 pID (1 ≤ moveInfo[0] ≤ 50,000)
         moveInfo[i] (1 ≤ i ≤ visitNum - 1) = 감염자가 이동한 방향 (0 ≤ moveInfo[i] ≤ 7)
	 * @param visitList visitList[]: 시작점을 포함해 감염자가 방문한 visitNum 개 장소의 pID 들을 저장하여 반환할 배열.
	 */
	void contactTracing(int uID, int visitNum, int moveInfo[], int visitList[]) {

	}

	/**
	 * uID 확진자가 방문했던 모든 장소의 소독이 완료되어 다시 이동 가능하게 된다.
	 * uID는 contactTracing() 함수로 호출이 된 적이 있음이 보장된다.
	 * 동일한 uID가 두 번 이상 disinfectPlaces() 함수로 호출되지 않음이 보장된다.
	 * uID가 방문했던 장소가 이미 삭제되었을 경우 해당 장소에 대해서는 아무 작업도 하지 않는다.
	 * @param uID 감염자의 ID (1 ≤ uID ≤ 1,000)
	 */
	void disinfectPlaces(int uID) {

	}
}