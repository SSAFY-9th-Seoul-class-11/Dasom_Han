package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {

	static int N, M;
	static int[] arr;
	static int res;

	public static void bfs() {

		Queue<Integer> que = new ArrayDeque<>();
		que.offer(1);
		int[] visited = new int[101]; // 방문 체크 및 주사위 굴린 횟수 체크
		visited[1] = 0;

		while (!que.isEmpty()) {
			int now = que.poll();
			if (now == 100) {
				System.out.println(visited[now]);
				return;
			}

			int next;
			for (int i = 1; i <= 6; i++) {
				next = now + i;
				if (next > 100)
					continue;
				if (visited[arr[next]] == 0) {// 가지 않았다면 지금까지의 이동 횟수 + 1 넣기
					visited[arr[next]] = visited[now] + 1;
					que.offer(arr[next]);
				}
			}
			
//			if (arr[now] == now) { // 뱀이나 사다리가 없는 경우 주사위를 굴려 나올 수 있는 모든 곳으로 가본다
//				for (int dice = 1; dice <= 6; dice++) {
//					next = now + dice;
//					if (next > 100)
//						break;
//					if (visited[next] == 0) {// 가지 않았다면 지금까지의 이동 횟수 + 1 넣기
//						visited[next] = visited[now] + 1;
//					} else {// 간 곳이라면 더 적게 걸린 이동 횟수로 업데이트
//						visited[next] = Math.min(visited[next], visited[now] + 1);
//					}
//					que.offer(next);
//				}
//			} else { // 뱀이나 사다리가 있다면 그곳으로 간다
//				next = arr[now];
//				if (visited[next] == 0) {
//					visited[next] = visited[now]; // 주사위 안굴리고 바로 감
//				} else {
//					visited[next] = Math.min(visited[next], visited[now]);
//				}
//				que.offer(next);
//			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[101];

		for (int i = 1; i <= 100; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}

		bfs();

	}

}
