package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Stack<Character> s = new Stack<>();
	static char ch[];

	static void func() {
		for (char x : ch) {
			if ('A' <= x && x <= 'Z')
				sb.append(x);
			else if (x == '(')
				s.push(x);
			else if (x == ')') {
				while (s.peek() != '(')
					sb.append(s.pop());
				s.pop();
			} else if (x == '+' || x == '-') {
				while (!s.isEmpty() && s.peek() != '(')
					sb.append(s.pop());
				s.push(x);
			} else {
				while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/'))
					sb.append(s.pop());
				s.push(x);
			}
		}

		while (!s.isEmpty())
			sb.append(s.pop());

		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		ch = st.nextToken().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}