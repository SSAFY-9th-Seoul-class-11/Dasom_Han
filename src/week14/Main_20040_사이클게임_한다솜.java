package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040_사이클게임_한다솜 {

	static int N, M, stopPoint;
	static int[] parent;
	static boolean isPlaying;

	public static int find(int A) {
		if (parent[A] == A)
			return A;
		return parent[A] = find(parent[A]);
	}

	public static boolean union(int A, int B) {
		int parentA = find(A);
		int parentB = find(B);
		if (parentA != parentB) {
			parent[parentB] = parentA;
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		stopPoint = M + 1; // 사이클 생성 시 멈춘 차례 저장
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		for (int game = 1; game <= M; game++) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (!union(A, B)) { // 사이클이 생기면
				System.out.println(game);
				System.exit(0);
			}
		}

		System.out.println(0);
	}

}
