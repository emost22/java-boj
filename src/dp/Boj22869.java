package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj22869 {
	static int list[], dp[];
	static int N, M;

	static int dfs(int x) {
		if (x == N - 1)
			return 1;

		if (dp[x] != -1)
			return dp[x];
		dp[x] = Integer.MAX_VALUE;

		for (int i = x + 1; i < N; i++) {
			dp[x] = Math.min(dp[x], Math.max(dfs(i), (i - x) * (1 + Math.abs(list[i] - list[x]))));
		}

		return dp[x];
	}

	static void func() {
		Arrays.fill(dp, -1);
		if (dfs(0) <= M)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N];
		dp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}