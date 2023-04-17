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
			if (inDegree[i] == 0)
				que.offer(i);
		}
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			for (int next : adjList[curr]) {
				dp[next] = Math.max(dp[next], dp[curr] + time[next]);
				if (--inDegree[next] == 0)
					que.offer(next);
				
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		return ans; 
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(bf.readLine());
		inDegree = new int[N + 1];
		adjList = new ArrayList[N + 1];
		time = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			if (prev > 0) {
				for (int j = 0; j < prev; j++) {
					int preWork = Integer.parseInt(st.nextToken());
					adjList[preWork].add(i);
					inDegree[i]++;
				}
			}
		}
		
		System.out.println(topology());
	}

}
