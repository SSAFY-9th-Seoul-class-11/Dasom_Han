package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1918_후위표기식 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String expression = bf.readLine();
		Stack<Character> postfix = new Stack<>();
		String res = "";

		for (int i = 0; i < expression.length(); i++) {

			char temp = expression.charAt(i);

			if (temp == '(') { // 1. 여는 괄호
				postfix.push(temp);
			} else if (temp == ')') { // 2. 닫는 괄호
				while (!postfix.isEmpty()) {
					char peekTemp = postfix.peek();
					if (peekTemp == '(') {
						postfix.pop();   // 여는 괄호 지워주기
						break;
					}
					res += postfix.pop();
				}
			} else if (temp == '*' || temp == '/') { // 3. 곱셈 나눗셈
				while (!postfix.isEmpty()) {
					char tempPeek = postfix.peek();
					if (tempPeek != '*' && tempPeek != '/')
						break;
					res += postfix.pop();
				}
				postfix.push(temp);
			} else if (temp == '+' || temp == '-') { // 4. 덧셈 뺄셈
				while (!postfix.isEmpty()) {
					char peekTemp = postfix.peek();
					if (peekTemp == '(') {
						break;
					}
					res += postfix.pop();
				}
				postfix.push(temp);
			} else { // 5. 피연산자(알파벳)
				res += temp;
			}
		}

		while (!postfix.isEmpty()) {
			char tempPop = postfix.pop();
			if (tempPop == '(' || tempPop == ')')
				continue;
			res += tempPop;
		}

		System.out.println(res);
	}

}
