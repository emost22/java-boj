package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15993 {
	static final int MOD = 1000000009;
	static int N;
	static int dp[][] = new int[100001][2];

	static void init() {
		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 2;
		dp[3][1] = 2;
		for (int i = 4; i <= 100000; i++) {
			dp[i][0] = ((dp[i - 1][1] + dp[i - 2][1]) % MOD + dp[i - 3][1]) % MOD;
			dp[i][1] = ((dp[i - 1][0] + dp[i - 2][0]) % MOD + dp[i - 3][0]) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		init();
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
}