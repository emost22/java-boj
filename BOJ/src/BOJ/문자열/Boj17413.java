package BOJ.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17413 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] ch;
	static Stack<Character> s = new Stack<>();

	static void func() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ch.length;) {
			if (ch[i] == '<') {
				while (!s.isEmpty())
					sb.append(s.pop());
				while (ch[i] != '>')
					sb.append(ch[i++]);
				sb.append(ch[i++]);
			} else if (ch[i] == ' ') {
				while (!s.isEmpty())
					sb.append(s.pop());
				sb.append(" ");
				i++;
			} else {
				s.push(ch[i]);
				i++;
			}
		}
		while (!s.isEmpty())
			sb.append(s.pop());

		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		ch = br.readLine().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}