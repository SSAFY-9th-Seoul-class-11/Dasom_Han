package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// swea 비밀번호와 유사
public class boj_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String bomb = bf.readLine();
		int len = bomb.length();  // 폭발 길이
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			stack.push(temp);
			boolean isSame = true;
			if (stack.size() >= len) {  
				for (int j = 0; j < len; j++) {
					// 폭발과 스택속 문자열 비교
					if (stack.get(stack.size() - len + j) != bomb.charAt(j))
						isSame = false;
				}
				if (isSame) {  // 같다면 길이만큼 pop
					for (int j = 0; j < len; j++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
	}

}
