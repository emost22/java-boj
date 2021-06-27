package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17090 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char list[][] = new char[510][510];
	static boolean visit[][] = new boolean[510][510];
	static int dp[][] = new int[510][510];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, ans;

	static int dfs(int x, int y) {
		if (visit[x][y])
			return 0;
		visit[x][y] = true;

		if (dp[x][y] != -1)
			return dp[x][y];

		int d = 0;
		if (list[x][y] == 'D')
			d = 1;
		else if (list[x][y] == 'R')
			d = 0;
		else if (list[x][y] == 'U')
			d = 3;
		else
			d = 2;

		int nx = x + direct[d][0];
		int ny = y + direct[d][1];

		if (nx < 0 || nx >= N || ny < 0 || ny >= M)
			dp[x][y] = 1;
		else {
			dp[x][y] = dfs(x + direct[d][0], y + direct[d][1]);
			visit[nx][ny] = false;	
		}

		return dp[x][y];
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dp[i][j] != -1) {
					ans += dp[i][j];
					continue;
				}
				ans += dfs(i, j);
				visit[i][j] = false;
			}
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			Arrays.fill(dp[i], -1);
		}

	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}