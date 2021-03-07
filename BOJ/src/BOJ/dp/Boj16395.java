package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16395 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[][] = new int[31][31];
	static int N, K;

	static void func() {
		dp[1][1] = 1;
		for (int i = 2; i <= 30; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(dp[N][K]);
	}

	public static void main(String[] args) throws Exception {
		func();
		input();
	}
}