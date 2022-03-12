package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1912 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[];
	static int N, ans = Integer.MIN_VALUE;

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
			ans = Math.max(ans, dp[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(ans);
	}
}