package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1937 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][] = new int[501][501];
	static int dp[][] = new int[501][501];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, ans;

	static int dfs(int x, int y) {
		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (list[x][y] >= list[nx][ny])
				continue;

			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
		}

		ans = Math.max(ans, dp[x][y]);
		return dp[x][y];
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] != -1)
					continue;
				dfs(i, j);
			}
		}
		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}