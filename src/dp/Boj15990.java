package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15990 {
	static final int MOD = 1000000009;
	static int N;
	static int dp[][] = new int[100001][3];

	static void init() {
		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		for (int i = 4; i <= 100000; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % MOD;
			dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tc = Integer.parseInt(st.nextToken());
		init();
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			System.out.println(((dp[N][0] + dp[N][1]) % MOD + dp[N][2]) % MOD);
		}
	}
}
