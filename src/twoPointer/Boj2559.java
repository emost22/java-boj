package twoPointer;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Boj2559 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], dp[];
	static int N, K, ans = Integer.MIN_VALUE;

	static void func() {
		int l = 1;
		int r = K;

		while (r <= N) {
			ans = Math.max(ans, dp[r] - dp[l - 1]);

			r++;
			l++;
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N + 1];
		dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i - 1] + list[i];
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}