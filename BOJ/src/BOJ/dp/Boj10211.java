package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10211 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int list[], dp[];
	static int N;

	static void func() {
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1] + list[i], list[i]);
			ans = Math.max(ans, dp[i]);
		}
		
		sb.append(ans).append("\n");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1];
		dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			func();
		}
		
		System.out.println(sb.toString());
	}
}