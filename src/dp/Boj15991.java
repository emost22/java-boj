package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15991 {
	static final int MOD = 1000000009;
	static int N;
	static int dp[] = new int[100001];

	static void init() {
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		for (int i = 6; i <= 100000; i++) {
			dp[i] = ((dp[i - 2] + dp[i - 4]) % MOD + dp[i - 6]) % MOD;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		init();
		while(tc-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			System.out.println(dp[N]);
		}
	}
}