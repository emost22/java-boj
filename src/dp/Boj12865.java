package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][], dp[][];
	static int N, K;

	static void func() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (list[i][0] > j) {
					dp[i][j] = dp[i - 1][j];
					continue;
				}

				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list[i][0]] + list[i][1]);
			}
		}

		System.out.println(dp[N][K]);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N + 1][2];
		dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
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