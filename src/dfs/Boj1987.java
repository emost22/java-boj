package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean visit[][], alphachk[];
	static char list[][];
	static int N, M, ans;

	static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		visit[x][y] = true;
		alphachk[list[x][y] - 'A'] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (visit[nx][ny] || alphachk[list[nx][ny] - 'A'])
				continue;

			dfs(nx, ny, cnt + 1);
			alphachk[list[nx][ny] - 'A'] = false;
			visit[nx][ny] = false;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new char[N][];
		visit = new boolean[N][M];
		alphachk = new boolean[26];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0, 1);
		System.out.println(ans);
	}
}