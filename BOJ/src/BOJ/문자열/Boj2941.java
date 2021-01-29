package BOJ.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2941 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char ch[];
	static int ans;

	static void func() {
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'c') {
				if (i + 1 < ch.length) {
					if (ch[i + 1] == '=' || ch[i + 1] == '-')
						i++;
				}
			} else if (ch[i] == 'd') {
				if (i + 2 < ch.length && ch[i + 1] == 'z' && ch[i + 2] == '=') {
					i += 2;
				} else if (i + 1 < ch.length && ch[i + 1] == '-') {
					i++;
				}
			} else if (ch[i] == 'l' || ch[i] == 'n') {
				if (i + 1 < ch.length) {
					if (ch[i + 1] == 'j')
						i++;
				}
			} else if (ch[i] == 's' || ch[i] == 'z') {
				if (i + 1 < ch.length) {
					if (ch[i + 1] == '=')
						i++;
				}
			}

			ans++;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		ch = st.nextToken().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.println(ans);
	}
}