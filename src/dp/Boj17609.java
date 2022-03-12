package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17609 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static char ch[];

	static void func() {
		int l = 0;
		int r = ch.length - 1;
		int ans = 0;
		int cnt = 0;
		while (l < r) {
			if (ch[l] == ch[r]) {
				l++;
				r--;
			} else {
				cnt++;
				l++;
			}

			if (cnt == 2)
				break;
		}
		ans = cnt;

		l = 0;
		r = ch.length - 1;
		cnt = 0;
		while (l < r) {
			if (ch[l] == ch[r]) {
				l++;
				r--;
			} else {
				cnt++;
				r--;
			}

			if (cnt == 2)
				break;
		}

		ans = Math.min(ans, cnt);
		sb.append(ans).append("\n");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		ch = st.nextToken().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			func();
		}
		System.out.println(sb.toString());
	}
}