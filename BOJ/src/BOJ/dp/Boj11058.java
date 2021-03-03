package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11058 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long dp[];
	static int N;

	static void func() {
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j < i - 2; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[j] * (i - (j + 2)));
			}
		}
		
		System.out.println(dp[N]);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new long[N + 1];
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}