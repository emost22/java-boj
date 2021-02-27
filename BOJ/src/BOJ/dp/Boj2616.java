package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2616 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[] = new int[50001];
	static int dp[][] = new int[50001][4];
	static int N, M;

	static void init() {
		for (int i = 1; i <= N; i++)
			Arrays.fill(dp[i], -1);
	}

	static int func(int idx, int cnt) {
		if (idx + M * cnt - 1 > N)
			return 0;
		if (cnt == 0)
			return 0;

		if (dp[idx][cnt] != -1)
			return dp[idx][cnt];

		dp[idx][cnt] = 0;

		dp[idx][cnt] = Math.max(func(idx + 1, cnt), func(idx + M, cnt - 1) + list[idx + M - 1] - list[idx - 1]);

		return dp[idx][cnt];
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		init();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			list[i] += list[i - 1];
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(func(1, 3));
	}
}