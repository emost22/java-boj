package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringBuffer sb = new StringBuffer();
	static Stack<Character> s = new Stack<>();
	static char[] ch;
	
	
	static void func() {
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(') {
				s.add(ch[i]);
			} else {
				if (s.isEmpty()) {
					sb.append("NO\n");
					return;
				}

				s.pop();
			}
		}

		if (s.isEmpty())
			sb.append("YES\n");
		else
			sb.append("NO\n");
	}

	static void input() throws Exception {
		str = br.readLine();
		ch = str.toCharArray();
	}

	public static void main(String[] args) throws Exception {
		str = br.readLine();
		int tc = Integer.parseInt(str);
		while (tc-- > 0) {
			input();
			func();
			while(!s.isEmpty())
				s.pop();
		}
		
		System.out.println(sb.toString());
	}
}