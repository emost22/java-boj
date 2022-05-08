package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj3372 {
	static int list[][];
	static BigInteger dp[][];
	static int direct[][] = { { 0, 1 }, { 1, 0 } };
	static int N;

	static BigInteger dfs(int x, int y) {
		if (x == N - 1 && y == N - 1)
			return new BigInteger("1");

		if (!dp[x][y].toString().equals("-1"))
			return dp[x][y];
		dp[x][y] = new BigInteger("0");

		for (int i = 0; i < 2; i++) {
			int nx = x + (direct[i][0] * list[x][y]);
			int ny = y + (direct[i][1] * list[x][y]);

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			dp[x][y] = dp[x][y].add(dfs(nx, ny));
		}

		return dp[x][y];
	}

	static void func() {		
		System.out.println(dfs(0, 0));
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		list = new int[N][N];
		dp = new BigInteger[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = new BigInteger("-1");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}
