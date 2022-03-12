package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringBuffer sb = new StringBuffer();
	static Stack<Character> s = new Stack<>();

	static boolean popStack(char x) {
		if(s.isEmpty())
			return false;
		
		if (x == ')') {
			if (s.peek() == '(') {
				s.pop();
				return true;
			} else
				return false;
		} else {
			if (s.peek() == '[') {
				s.pop();
				return true;
			} else
				return false;
		}
	}

	static void func() {
		char ch[] = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(' || ch[i] == '[') {
				s.add(ch[i]);
			} else if (ch[i] == ')' || ch[i] == ']') {
				if (!popStack(ch[i])) {
					sb.append("no\n");
					return;
				}
			}
		}

		if (s.isEmpty())
			sb.append("yes\n");
		else
			sb.append("no\n");
	}

	static void input() throws Exception {
		str = br.readLine();
	}

	public static void main(String[] args) throws Exception {
		while (true) {
			input();
			if (".".equals(str))
				break;

			func();
			while (!s.isEmpty())
				s.pop();
		}

		System.out.println(sb.toString());
	}
}