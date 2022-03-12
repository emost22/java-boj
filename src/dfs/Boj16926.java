package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int visit[][];
	static int list[][];
	static int N, M, R;
	static int sx, sy, ex, ey;

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(list[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static int dfs(int x, int y, int idx) {
		visit[x][y]++;

		int nx = x + direct[idx][0];
		int ny = y + direct[idx][1];

		if (nx < sx || ny < sy || nx > ex || ny > ey) {
			idx++;
			nx = x + direct[idx][0];
			ny = y + direct[idx][1];
		}

		if (visit[nx][ny] == visit[x][y]) {
			int tmp = list[x][y];
			list[x][y] = list[nx][ny];
			return tmp;
		}

		int tmp = list[x][y];
		list[x][y] = dfs(nx, ny, idx);
		return tmp;
	}

	static void solve() {
		sx = 0;
		sy = 0;
		ex = N - 1;
		ey = M - 1;
		int n = N;
		int m = M;
		for (int i = 0;; i++) {
			for (int j = 0; j < R % ((n - 1) * 2 + (m - 1) * 2); j++) {
				dfs(i, i, 0);
			}
			sx++;
			sy++;
			ex--;
			ey--;
			n -= 2;
			m -= 2;
			if (sx > ex || sy > ey)
				break;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
		print();
	}
}