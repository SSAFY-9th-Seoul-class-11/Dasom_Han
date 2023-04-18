package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2056_작업_한다솜 {

	static int N;
	static int[] inDegree, dp, time;
	static ArrayList<Integer>[] adjList;
	
	public static int topology() {
		Queue<Integer> que = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; i++) {
			dp[i] = time[i];
			if (inDegree[i] == 0)  // 진입차수 0인 것 먼저 큐에 넣기
				que.offer(i);
		}
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			for (int next : adjList[curr]) {  
				// 다음 작업까지의 최소 시간 = Math.max(다음까지의 최소 시간, 현재까지의 최소 시간 + 다음 작업 소요 시간)
				dp[next] = Math.max(dp[next], dp[curr] + time[next]);
				if (--inDegree[next] == 0)  // 나 다음 작업의 진입차수가 0이면 큐에 추가
					que.offer(next);
				
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) { 
			ans = Math.max(ans, dp[i]);  // 가장 긴 시간이 끝까지 수행했을 때의 최소 시간
		}
		
		return ans; 
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(bf.readLine());
		inDegree = new int[N + 1];  // 진입 차수 배열
		adjList = new ArrayList[N + 1];  // 나 다음에 오는 작업 리스트
		time = new int[N + 1];  // 각 작업당 걸리는 시간 배열
		dp = new int[N + 1];  // n번 작업을 끝낼 때까지의 최소 시간 배열
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());  // 이 작업 전에 수행되어야 할 작업 개수
			if (prev > 0) {
				for (int j = 0; j < prev; j++) {
					int preWork = Integer.parseInt(st.nextToken());
					adjList[preWork].add(i);  // 선행 작업 리스트에 이 작업을 add
					inDegree[i]++;  // 지금 작업의 진입 차수 ++ 
				}
			}
		}
		
		System.out.println(topology());
	}

}
