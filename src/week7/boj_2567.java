import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2567 {        // 색종이 - 2

	static class Scarf {
		int startX, startY, endX, endY;

		public Scarf(int startX, int startY) {
			super();
			this.startX = startX;
			this.startY = startY;
			this.endX = startX + 9;          // 한장에 10칸이어야 하므로
			this.endY = startY + 9;
		}
	}

	static Scarf[] scarfs;
	static int[][] map;
	static int res;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static void getPerimeter() {

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {           // 1인 칸이라면
					for (int d = 0; d < 4; d++) {      // 상하좌우 탐색하면서
						int x = i + dir[d][0];
						int y = j + dir[d][1];
						if (map[x][y] == 0)       // 0을 만났을 때 스카프의 경계이므로 둘레+1
							res++;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		scarfs = new Scarf[N];
		map = new int[101][101];
		res = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			scarfs[i] = new Scarf(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// -------입력--------

		for (int s = 0; s < N; s++) {
			for (int i = scarfs[s].startX; i <= scarfs[s].endX; i++) {
				for (int j = scarfs[s].startY; j <= scarfs[s].endY; j++) {
					map[i][j] = 1;
				}
			}
		}
		// 101 * 101 배열에 검정 스카프가 위치한 곳을 1로 설정
		// 101인 이유는 (90, 90)인 경우를 위해서

		getPerimeter();
		// 1->0이 되는 순간 둘레+1 해준다

		System.out.println(res);
	}

}