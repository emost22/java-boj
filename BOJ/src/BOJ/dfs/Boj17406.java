package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<int[]> rotate = new ArrayList<>();
	static ArrayList<int[]> rotatesolve = new ArrayList<>();
	static boolean visit[][], chk[];
	static int list[][], clist[][];
	static int N, M, K, r, c, s;
	static int sx, sy, ex, ey, ans = Integer.MAX_VALUE;

	static void print() {
		System.out.println(ans);
	}

	static int dfs(int x, int y, int idx) {
		visit[x][y] = true;

		int nx = x + direct[idx][0];
		int ny = y + direct[idx][1];

		if (nx < sx || ny < sy || nx > ex || ny > ey) {
			idx++;
			nx = x + direct[idx][0];
			ny = y + direct[idx][1];
			if (nx < sx || ny < sy || nx > ex || ny > ey) {
				nx = x;
				ny = y;
			}
		}

		if (visit[nx][ny]) {
			int tmp = clist[x][y];
			clist[x][y] = clist[nx][ny];
			return tmp;
		}

		int tmp = clist[x][y];
		clist[x][y] = dfs(nx, ny, idx);
		return tmp;
	}

	static void solve(int rr, int cc, int ss) {
		sx = rr - ss;
		sy = cc - ss;
		ex = rr + ss;
		ey = cc + ss;

		for (int i = 0;; i++) {
			dfs(sx, sy, 0);
			sx++;
			sy++;
			ex--;
			ey--;
			if (sx > ex || sy > ey)
				break;
		}

		for (int i = rr - ss; i <= rr + ss; i++) {
			Arrays.fill(visit[i], false);
		}
	}

	static void func(int cnt) {
		if (cnt == K) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++)
					clist[i][j] = list[i][j];
			}
			for (int i = 0; i < K; i++) {
				solve(rotatesolve.get(i)[0], rotatesolve.get(i)[1], rotatesolve.get(i)[2]);
			}

			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += clist[i][j];
				}
				ans = Math.min(ans, sum);
			}

			return;
		}

		for (int i = 0; i < K; i++) {
			if (chk[i])
				continue;

			rotatesolve.add(rotate.get(i));
			chk[i] = true;
			func(cnt + 1);
			chk[i] = false;
			rotatesolve.remove(cnt);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N + 1][M + 1];
		clist = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			rotate.add(new int[] { r, c, s });
		}

		chk = new boolean[K];
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0);
		print();
	}
}