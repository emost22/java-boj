package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static boolean visit[][];
	static char list[][];
	static int N, M, ans;

	static boolean dfs(int x, int y) {
		visit[x][y] = true;
		if (y == M - 1)
			return true;

		for (int i = 0; i < 3; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (visit[nx][ny] || list[nx][ny] == 'x')
				continue;

			boolean chk = dfs(nx, ny);
			if (chk)
				return true;
		}

		return false;
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			if (dfs(i, 0))
				ans++;
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new char[N][];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}