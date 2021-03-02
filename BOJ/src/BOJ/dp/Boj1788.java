package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1788 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MOD = 1000000000;
	static int dp[] = new int[1000001];
	static int N;

	static void init() {
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
		}
	}

	static void func() {
		if (N < 0) {
			N = -N;
			if (N % 2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
		} else if (N == 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
		System.out.println(Math.abs(dp[N]));
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		init();
		input();
		func();
	}
}