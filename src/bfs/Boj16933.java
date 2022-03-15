package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj16933 {
	static char list[][];
	static boolean visit[][][];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, K;

	static int bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.addLast(new int[] { 0, 0, 0 });
		visit[0][0][0] = true;
		for (int t = 1; !q.isEmpty(); t++) {
			int qsize = q.size();
			while (qsize-- > 0) {
				int x = q.peekFirst()[0];
				int y = q.peekFirst()[1];
				int k = q.pollFirst()[2];

				if (x == N - 1 && y == M - 1) {
					return t;
				}

				for (int i = 0; i < 4; i++) {
					int nx = x + direct[i][0];
					int ny = y + direct[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if (list[nx][ny] == '1') {
						if (k == K)
							continue;
						if (visit[nx][ny][k + 1])
							continue;

						if (t % 2 == 0) {
							q.addLast(new int[] { x, y, k });
						} else {
							visit[nx][ny][k + 1] = true;
							q.addLast(new int[] { nx, ny, k + 1 });
						}
					} else {
						if (visit[nx][ny][k])
							continue;

						q.addLast(new int[] { nx, ny, k });
						visit[nx][ny][k] = true;
					}
				}
			}
		}

		return -1;
	}

	static void func() {
		System.out.println(bfs());
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new char[N][M];
		visit = new boolean[N][M][K + 1];

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