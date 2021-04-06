package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1915 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[][] = new int[1001][1001];
	static int N, M, ans;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			char ch[] = st.nextToken().toCharArray();
			for (int j = 1; j <= M; j++) {
				dp[i][j] = ch[j - 1] - '0';

				if (dp[i][j] == 1) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(ans * ans);
	}
}