package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj_7662 { // 이중 우선순위 큐

	static int k;
	static TreeMap<Integer, Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			k = Integer.parseInt(bf.readLine());
			map = new TreeMap<Integer, Integer>();
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				char cmd = st.nextToken().charAt(0);
				int value = Integer.parseInt(st.nextToken());

				if (cmd == 'I') { // 삽입
					// value라는 키에 이미 값이 있다면 그것에 +1, 키가 처음 저장되면 1로 초기화
					map.put(value, map.getOrDefault(value, 0) + 1);
				} else {  // 삭제
					if (map.isEmpty())
						continue;
					if (value == 1) {  // 최대값 삭제
						int big = map.lastKey();
						int cnt = map.get(big);
						if (cnt == 1) // 1개만 남았다면 삭제
							map.pollLastEntry();
						else  // 아니면 cnt-1한 값을 추가(어차피 key는 존재하므로 덮어씌워짐)
							map.put(big, cnt - 1);
					}
					else if (value == -1) { // 최소값 삭제
						int small = map.firstKey();
						int cnt = map.get(small);
						if (cnt == 1)
							map.pollFirstEntry();
						else 
							map.put(small, cnt - 1);
					}
				}
			}

			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}
}
