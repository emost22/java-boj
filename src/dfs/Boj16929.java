package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj16929 {
	static char list[][];
	static boolean visit[][];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M;

	static boolean dfs(int sx, int sy, int x, int y, int cnt) {
		if (cnt > 1 && sx == x && sy == y) {
			if (cnt >= 4)
				return true;
			else
				return false;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (visit[nx][ny])
				continue;
			if (list[x][y] != list[nx][ny])
				continue;

			visit[nx][ny] = true;
			if (dfs(sx, sy, nx, ny, cnt + 1))
				return true;
			visit[nx][ny] = false;
		}

		return false;
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++)
					Arrays.fill(visit[i], false);

				if (dfs(i, j, i, j, 1)) {
					System.out.println("Yes");
					return;
				}
			}
		}

		System.out.println("No");
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new char[N][M];
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