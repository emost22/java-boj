package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj12920 {
	static class Pair {
		int weight;
		int score;

		public Pair(int weight, int score) {
			this.weight = weight;
			this.score = score;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<Pair> q = new LinkedList<>();
	static int N, M;

	static void func() {
		int dp[][] = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			Pair p = q.poll();
			for (int j = 1; j <= M; j++) {
				if (p.weight > j) {
					dp[i][j] = dp[i - 1][j];
					continue;
				}

				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p.weight] + p.score);
			}
		}

		System.out.println(dp[N][M]);
	}

	static void input() throws Exception {
		int v, c, k;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= k; j <<= 1) {
				q.add(new Pair(v * j, c * j));
				k -= j;
			}
			
			if (k > 0) {
				q.add(new Pair(v * k, c * k));
			}
		}

		N = q.size();
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}