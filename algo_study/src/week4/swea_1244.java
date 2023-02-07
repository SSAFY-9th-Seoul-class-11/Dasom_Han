package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_1244 {

	static private char[] num;
	static private int cnt;
	static private int res;
	static private Map<Integer, Integer> visited;
	
	public static void swap(int a, int b) {
		char temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	// 2C6 ^ 10
	public static void exchange(int total) {
		if (total == cnt) {
			res = Math.max(res, Integer.parseInt(new String(num)));
			return;
		}
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				swap(i, j);
				int temp = Integer.parseInt(new String(num));
				if (!visited.containsKey(total) || (visited.containsKey(total) && visited.get(total) != temp)) {
					exchange(total + 1);
					visited.put(total, temp);
				}
				swap(i, j);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String temp = st.nextToken();
			num = temp.toCharArray();
			cnt = Integer.parseInt(st.nextToken());
			res = 0;
			visited = new HashMap<Integer, Integer>();
			exchange(0);
			System.out.println("#" + test_case + " " + res);
		}
	}

}

// def dfs(n):
//     global ans
//     if n == count:
//         ans = max(ans, int("".join(map(str, num_lst))))
//         return
//     for i in range(L-1):
//         for j in range(i+1, L):
//             num_lst[i], num_lst[j] = num_lst[j], num_lst[i]
//             chk = int("".join(map(str, num_lst)))
//             if (n, chk) not in visited:
//                 dfs(n+1)
//                 visited.append((n, chk))
//             num_lst[i], num_lst[j] = num_lst[j], num_lst[i]
            
// T = int(input())
// for tc in range(1, T+1):
//     num, count = input().split()
//     count = int(count)
//     num_lst = []
//     for n in num:
//         num_lst.append(int(n))
//     L = len(num_lst)
//     ans = 0
//     visited = []
//     dfs(0)
//     print(f"#{tc} {ans}")
