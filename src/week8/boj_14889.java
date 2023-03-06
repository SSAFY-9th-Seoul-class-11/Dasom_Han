package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14889 { // 스타트와 링크

	static int N;
	static int[][] S;
	static boolean[] isSelected;
	static int min;

	private static int abilityCheck(List<Integer> team) {     // 팀별 능력치 구하기
		int sum = 0;
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				sum += S[team.get(i)][team.get(j)] + S[team.get(j)][team.get(i)];
			}
		}
		return sum;
	}

	private static void assignTeam(int curr, int cnt) {  // N개에서 N/2개 뽑기

		if (cnt == N / 2) {     
			List<Integer> start = new ArrayList<>();
			List<Integer> link = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					start.add(i);
				} else {
					link.add(i);
				}
			}
			min = Math.min(min, Math.abs(abilityCheck(start) - abilityCheck(link)));   // 차이 최소값 갱신
			return;
		}

		for (int i = curr; i < N; i++) {
			isSelected[i] = true;
			assignTeam(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		S = new int[N][N];
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		assignTeam(0, 0);
		System.out.println(min);
	}

}
