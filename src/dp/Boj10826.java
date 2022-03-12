package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj10826 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;

	static void solve() {
		BigInteger dp[] = new BigInteger[10001];
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}

		System.out.println(dp[N]);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}