package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2698 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int dp[][][] = new int[101][101][2];
	static int N, K;

	static void func() {
		dp[1][0][0] = 2;
		dp[2][0][0] = 3;
		dp[2][0][1] = 1;
		dp[2][1][0] = 1;
		for (int i = 3; i <= 100; i++) {
			dp[i][0][0] = dp[i - 1][0][0] + dp[i - 2][0][0];
			dp[i][0][1] = dp[i - 2][0][0];
			for (int j = 1; j < i - 1; j++) {
				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 2][j][0] + dp[i - 1][j - 1][1];
				dp[i][j][1] = dp[i - 2][j][0] + dp[i - 1][j - 1][1];
			}
			dp[i][i - 1][0] = 1;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		func();
		while (tc-- > 0) {
			input();
			sb.append(dp[N][K][0]).append("\n");
		}

		System.out.println(sb.toString());
	}
}