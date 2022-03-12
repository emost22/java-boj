package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj20419 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][];
	static int direct[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean visit[][][];
	static int N, M, K;

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0 });
		visit[0][0][0] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int k = q.peek()[2];
			q.remove();

			if (x == N - 1 && y == M - 1) {
				System.out.println("Yes");
				return;
			}

			int d = list[x][y];
			int nx = x + direct[d][0];
			int ny = y + direct[d][1];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visit[nx][ny][k]) {
					q.add(new int[] { nx, ny, k });
					visit[nx][ny][k] = true;
				}
			}

			if (K > 0) {
				if ((1 & k) == 0) { // Left
					int nk = k | 1;
					int nd = d - 1;
					if (nd == -1)
						nd = 3;

					nx = x + direct[nd][0];
					ny = y + direct[nd][1];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (!visit[nx][ny][nk]) {
							q.add(new int[] { nx, ny, nk });
							visit[nx][ny][nk] = true;
						}
					}
				}

				if ((2 & k) == 0) { // Right
					int nk = k | 2;
					int nd = d + 1;
					if (nd == 4)
						nd = 0;

					nx = x + direct[nd][0];
					ny = y + direct[nd][1];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (!visit[nx][ny][nk]) {
							q.add(new int[] { nx, ny, nk });
							visit[nx][ny][nk] = true;
						}
					}
				}
			}

		}

		System.out.println("No");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		visit = new boolean[N][M][4];
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				if (ch == 'U')
					list[i][j] = 0;
				else if (ch == 'R')
					list[i][j] = 1;
				else if (ch == 'D')
					list[i][j] = 2;
				else
					list[i][j] = 3;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}