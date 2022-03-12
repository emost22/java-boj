package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1062_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char list[][] = new char[50][16];
	static boolean alpha[] = new boolean[26];
	static int N, M, ans;

	static void init() {
		alpha['a' - 'a'] = true;
		alpha['c' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['t' - 'a'] = true;
	}

	static void dfs(int idx, int cnt) {
		if (cnt == M) {
			int readCnt = 0;
			for (int i = 0; i < N; i++) {
				boolean chk = true;
				for (int j = 0; j < list[i].length; j++) {
					if (!alpha[list[i][j] - 'a']) {
						chk = false;
						break;
					}
				}

				if (chk)
					readCnt++;
			}

			ans = Math.max(ans, readCnt);
			return;
		}

		for (int i = idx; i < 26; i++) {
			if (alpha[i])
				continue;

			alpha[i] = true;
			dfs(i + 1, cnt + 1);
			alpha[i] = false;
		}
	}

	static void func() {
		if (M < 5) {
			System.out.println(0);
			return;
		}

		init();
		dfs(0, 5);
		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}