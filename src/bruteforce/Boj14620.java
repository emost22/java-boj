package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14620 {
	static final int MAX = 3;
	static int list[][], N, ans;
	static boolean visit[][];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static void dfs(int x, int y, int cnt, int sum) {
		if (ans <= sum)
			return;

		if (cnt == MAX) {
			ans = Math.min(ans, sum);
			return;
		}

		if (x == N - 1)
			return;

		if (y + 1 >= N - 1)
			dfs(x + 1, 1, cnt, sum);
		else
			dfs(x, y + 1, cnt, sum);

		if (visit[x][y])
			return;
		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			if (visit[nx][ny])
				return;
		}

		int addSum = list[x][y];
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			visit[nx][ny] = true;
			addSum += list[nx][ny];
		}

		if (y + 2 >= N - 1)
			dfs(x + 1, 1, cnt + 1, sum + addSum);
		else
			dfs(x, y + 2, cnt + 1, sum + addSum);

		visit[x][y] = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			visit[nx][ny] = false;
		}
	}

	static void func() {
		ans = Integer.MAX_VALUE;
		dfs(1, 1, 0, 0);
		System.out.println(ans);
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		list = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
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