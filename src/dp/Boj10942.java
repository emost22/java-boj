package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10942 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[][] = new int[2001][2001];
	static int list[] = new int[2001];
	static int N, M;

	static void solve() throws Exception {
		StringBuffer sb = new StringBuffer();
		int l, r;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			sb.append(dp[l][r]).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void func() {
		for (int i = 2; i < N; i++) {
			for (int j = 1; j + i <= N; j++) {
				if (list[j] == list[j + i] && dp[j + 1][j + i - 1] == 1) {
					dp[j][j + i] = 1;
				}
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());

			dp[i][i] = 1;
			if (list[i - 1] == list[i])
				dp[i - 1][i] = 1;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		solve();
	}
}