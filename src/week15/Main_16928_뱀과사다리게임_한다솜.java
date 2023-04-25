package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}


public class Main_16928_뱀과사다리게임_한다솜 {

	static int N, M;
	static int[] arr;
	static int res;
	
	public static void bfs() {
		
		Queue<Pos> que = new ArrayDeque<>();
		
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[101];
		
		for (int i = 1; i <= 100 ; i++) {
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
