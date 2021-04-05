package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2573 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][] = new int[300][300];
	static int cnt[][] = new int[300][300];
	static boolean visit[][] = new boolean[300][300];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M;

	static void init() {
		for (int i = 0; i < N; i++)
			Arrays.fill(visit[i], false);
	}

	static void bfs(int sx, int sy) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { sx, sy });
		visit[sx][sy] = true;
		while (!dq.isEmpty()) {
			int x = dq.peek()[0];
			int y = dq.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (visit[nx][ny] || list[nx][ny] == 0)
					continue;

				dq.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void func() {
		for (int t = 0;; t++) {
			boolean chk = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (list[i][j] == 0 || visit[i][j])
						continue;
					if (chk) {
						System.out.println(t);
						return;
					}
					bfs(i, j);
					chk = true;
				}
			}

			if (!chk) {
				System.out.println(0);
				return;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (list[i][j] == 0)
						continue;
					for (int k = 0; k < 4; k++) {
						int nx = i + direct[k][0];
						int ny = j + direct[k][1];

						if (list[nx][ny] == 0)
							cnt[i][j]++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (list[i][j] == 0)
						continue;
					list[i][j] = list[i][j] >= cnt[i][j] ? list[i][j] - cnt[i][j] : 0;
					cnt[i][j] = 0;
				}
			}

			init();
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}