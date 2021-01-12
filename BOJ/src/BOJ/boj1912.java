package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1912 {
	static int dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st1.nextToken());
		dp = new int[N + 1];
		int ans = -1000;

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int x = Integer.parseInt(st2.nextToken());

			if (dp[i - 1] + x < x)
				dp[i] = x;
			else
				dp[i] = dp[i - 1] + x;

			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}
}
