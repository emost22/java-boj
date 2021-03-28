package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1520 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][] = new int[500][500];
	static int dp[][] = new int[500][500];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M;

	static int func(int x, int y) {
		if (x == N - 1 && y == M - 1)
			return 1;
		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (list[x][y] <= list[nx][ny])
				continue;

			dp[x][y] += func(nx, ny);
		}
		
		return dp[x][y];
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(func(0, 0));
	}
}