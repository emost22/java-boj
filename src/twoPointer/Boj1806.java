package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], dp[];
	static int N, S, ans = 100000;

	static void func() {
		int l = 1;
		int r = 1;

		while (r <= N) {
			if (dp[r] - dp[l - 1] < S) {
				r++;
			} else {
				ans = Math.min(ans, r - l + 1);
				l++;
			}
		}

		if (ans == 100000)
			ans = 0;
		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
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