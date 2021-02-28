package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17404 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][], dp[][];
	static int N, ans;

	static void solve() {
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + list[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + list[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + list[i][2];
		}
	}

	static void func() {
		dp[1][0] = list[1][0];
		dp[1][1] = 1001;
		dp[1][2] = 1001;
		solve();
		ans = Math.min(dp[N][1], dp[N][2]);

		dp[1][0] = 1001;
		dp[1][1] = list[1][1];
		dp[1][2] = 1001;
		solve();
		ans = Math.min(ans, Math.min(dp[N][0], dp[N][2]));

		dp[1][0] = 1001;
		dp[1][1] = 1001;
		dp[1][2] = list[1][2];
		solve();
		ans = Math.min(ans, Math.min(dp[N][0], dp[N][1]));
		
		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1][3];
		dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}