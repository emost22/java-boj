package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1103 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char list[][] = new char[50][50];
	static boolean visit[][] = new boolean[50][50];
	static int dp[][] = new int[50][50];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, ans;

	static int dfs(int x, int y) {
		if (visit[x][y])
			return ans = -1;
		visit[x][y] = true;
		if (dp[x][y] != -1)
			return dp[x][y];

		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0] * (list[x][y] - '0');
			int ny = y + direct[i][1] * (list[x][y] - '0');

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (list[nx][ny] == 'H')
				continue;

			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			if (ans == -1)
				return ans;
			visit[nx][ny] = false;
		}

		return dp[x][y];
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			list[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		ans = dfs(0, 0);
		if (ans != -1)
			ans++;
		System.out.println(ans);
	}
}