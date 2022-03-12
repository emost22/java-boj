package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1010 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int dp[][] = new int[31][31];
	static int N, M;

	static void init() {
		for (int i = 1; i <= 30; i++) {
			dp[i][0] = 1;
			dp[0][i] = 1;
		}

		for (int i = 1; i <= 30; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		int N, K;
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			sb.append(dp[K][N] + "\n");
		}

		System.out.println(sb.toString());
	}
}