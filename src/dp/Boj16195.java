package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16195 {
	static final int MOD = 1000000009;
	static int N, M;
	static int list[][] = new int[1001][1001];
	static int dp[][] = new int[1001][1001];

	static void init() {
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 2;
		dp[3][1] = 1;
		dp[3][2] = 3;
		dp[3][3] = 4;
		list[1][1] = 1;
		list[2][1] = 1;
		list[2][2] = 1;
		list[3][1] = 1;
		list[3][2] = 2;
		list[3][3] = 1;
		for (int i = 4; i <= 1000; i++) {
			for (int j = 2; j <= i; j++) {
				list[i][j] = ((list[i - 1][j - 1] + list[i - 2][j - 1]) % MOD + list[i - 3][j - 1]) % MOD;
				dp[i][j] = (((dp[i][j - 1] + list[i - 1][j - 1]) % MOD + list[i - 2][j - 1]) % MOD + list[i - 3][j - 1]) % MOD;
			}
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
			M = Integer.parseInt(st.nextToken());

			System.out.println(dp[N][M]);
		}
	}
}
