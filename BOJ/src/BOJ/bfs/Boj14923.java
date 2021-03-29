package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj14923 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<int[]> dq = new ArrayDeque<>();
	static int list[][] = new int[1001][1001];
	static boolean visit[][][] = new boolean[1001][1001][2];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, ex, ey;

	static void bfs() {
		for (int t = 1;; t++) {
			int size = dq.size();
			while (size-- > 0) {
				int x = dq.peek()[0];
				int y = dq.peek()[1];
				int cnt = dq.poll()[2];

				for (int i = 0; i < 4; i++) {
					int nx = x + direct[i][0];
					int ny = y + direct[i][1];

					if (nx < 1 || ny < 1 || nx > N || ny > M)
						continue;
					if (list[nx][ny] == 1) {
						if (cnt > 0 || visit[nx][ny][1])
							continue;

						dq.add(new int[] { nx, ny, 1 });
						visit[nx][ny][1] = true;
					} else {
						if (visit[nx][ny][cnt])
							continue;

						dq.add(new int[] { nx, ny, cnt });
						visit[nx][ny][cnt] = true;

						if (nx == ex && ny == ey) {
							System.out.println(t);
							return;
						}
					}
				}
			}

			if (dq.isEmpty()) {
				System.out.println(-1);
				return;
			}
		}
	}

	static void input() throws Exception {
		int x, y;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dq.add(new int[] { x, y, 0 });
		visit[x][y][0] = true;

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		ex = x;
		ey = y;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}