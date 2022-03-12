package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15486 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][], dp[];
	static int N;

	static void func() {
		if (list[N][0] == 1)
			dp[N] = list[N][1];

		for (int i = N - 1; i >= 1; i--) {
			if (list[i][0] + i - 1 <= N)
				dp[i] = Math.max(dp[i + 1], dp[i + list[i][0]] + list[i][1]);
			else
				dp[i] = dp[i + 1];
		}

		System.out.println(dp[1]);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1][2];
		dp = new int[N + 2];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}