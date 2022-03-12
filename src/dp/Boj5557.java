package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj5557 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long dp[][];
	static int N, list[];

	static long func(int idx, int now) {
		if (idx == N - 1) {
			if (now == list[idx])
				return dp[idx][now] = 1;
			return dp[idx][now] = 0;
		}

		if (dp[idx][now] != -1)
			return dp[idx][now];

		dp[idx][now] = 0;

		if (now + list[idx] <= 20)
			dp[idx][now] += func(idx + 1, now + list[idx]);

		if (now - list[idx] >= 0)
			dp[idx][now] += func(idx + 1, now - list[idx]);

		return dp[idx][now];
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		dp = new long[N][21];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void init() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		init();
		System.out.println(func(1, list[0]));
	}
}