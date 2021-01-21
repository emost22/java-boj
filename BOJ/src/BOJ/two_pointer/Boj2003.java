package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], dp[];
	static int N, M, ans;

	static void func() {
		int l = 1;
		int r = 1;
		while (r < list.length) {
			if (dp[r] - dp[l - 1] == M) {
				ans++;
				l++;
			} else if (dp[r] - dp[l - 1] > M) {
				l++;
			} else
				r++;
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
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