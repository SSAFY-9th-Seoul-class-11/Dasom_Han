package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램_한다솜 {

	static int N, M;
	static int[] inDegree;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> result;
	
	public static void topology() {
		Queue<Integer> que = new ArrayDeque<>();
		
		for (int singer = 1; singer <= N; singer++) {
			if(inDegree[singer] == 0)
				que.offer(singer);
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			result.add(now);
			for (int next : adjList[now]) {
				if (--inDegree[next] == 0) 
					que.offer(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		adjList = new ArrayList[N + 1];
		result = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int pd = 0; pd < M; pd++) {
			st = new StringTokenizer(bf.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int[] singers = new int[cnt];
			for (int i = 0; i < cnt; i++) {
				singers[i] = Integer.parseInt(st.nextToken());
			}
			int from = 0;
			int to = 0;
			for (int s = 0; s < cnt - 1; s++) {
				from = s;
				to = s + 1;
				adjList[singers[from]].add(singers[to]);
				inDegree[singers[to]]++;
			}
		}
		
		topology();
		if (result.size() == N) {
			for (int singer : result) {
				System.out.println(singer);
			}
		} else {
			System.out.println(0);
		}
	}

}
