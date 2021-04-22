package BOJ.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj5052 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static String list[];
	static int N;

	static void func() {
		for (int i = 1; i < N; i++) {
			if (list[i - 1].length() > list[i].length())
				continue;

			for (int j = 0; j < list[i - 1].length(); j++) {
				if (list[i - 1].charAt(j) != list[i].charAt(j))
					break;
				else if (j == list[i - 1].length() - 1) {
					sb.append("NO\n");
					return;
				}
			}

		}
		sb.append("YES\n");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new String[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken();
		}
		Arrays.sort(list);
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