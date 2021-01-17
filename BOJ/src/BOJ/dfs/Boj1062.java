package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1062 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String word[] = new String[50];
	static boolean alpha[] = new boolean[26];
	static int N, K, ans;

	static void init() {
		alpha['a' - 'a'] = true;
		alpha['c' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['t' - 'a'] = true;
	}

	static void dfs(char ch, int cnt) {
		if (cnt == 0) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				boolean chk = false;
				for (int j = 0; j < word[i].length(); j++) {
					char a = word[i].charAt(j);
					if (!alpha[a - 'a']) {
						chk = true;
						break;
					}
				}

				if (!chk)
					sum++;
			}

			ans = Math.max(ans, sum);
			return;
		}

		for (char i = ch; i <= 'z'; i++) {
			if (alpha[i - 'a'])
				continue;
			alpha[i - 'a'] = true;
			dfs((char) (i + 1), cnt - 1);
			alpha[i - 'a'] = false;
		}
	}

	static void input() throws Exception {
		init();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			word[i] = st.nextToken();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		if (K < 5) {
			System.out.println(0);
			return;
		}

		dfs('b', K - 5);

		System.out.println(ans);
	}
}
