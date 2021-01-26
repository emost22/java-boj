package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj4889 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Stack<Character> s = new Stack<>();
	static char ch[];
	static int ans = 0;

	static void func() {
		for (char x : ch) {
			if (x == '{') {
				s.push(x);
			} else {
				if (s.isEmpty()) {
					ans++;
					s.push('{');
				} else
					s.pop();
			}
		}

		ans += (s.size() / 2);
		sb.append(ans + "\n");
		ans = 0;
		while (!s.isEmpty())
			s.pop();
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		ch = st.nextToken().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		for (int T = 1;; T++) {
			input();
			if (ch[0] == '-')
				break;

			sb.append(T + ". ");
			func();
		}
		
		System.out.println(sb.toString());
	}
}