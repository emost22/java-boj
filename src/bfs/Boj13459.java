package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj13459 {
	static final int MAX = 10;
	static int rxy[], bxy[];
	static char list[][];
	static boolean visit[][][][];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M;

	static int bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.addLast(new int[] { rxy[0], rxy[1], bxy[0], bxy[1] });
		visit[rxy[0]][rxy[1]][bxy[0]][bxy[1]] = true;
		for (int t = 1; t <= 10; t++) {
			int qsize = q.size();
			while (qsize-- > 0) {
				int rx = q.peekFirst()[0];
				int ry = q.peekFirst()[1];
				int bx = q.peekFirst()[2];
				int by = q.pollFirst()[3];

				for (int i = 0; i < 4; i++) {
					boolean rholl = false;
					boolean bholl = false;

					int nrx = rx;
					int nry = ry;
					while (true) {
						nrx += direct[i][0];
						nry += direct[i][1];

						if (nrx < 0 || nry < 0 || nrx >= N || nry >= M || list[nrx][nry] == '#') {
							nrx -= direct[i][0];
							nry -= direct[i][1];
							break;
						}

						if (list[nrx][nry] == 'O') {
							rholl = true;
							break;
						}
					}

					int nbx = bx;
					int nby = by;
					while (true) {
						nbx += direct[i][0];
						nby += direct[i][1];

						if (nbx < 0 || nby < 0 || nbx >= N || nby >= M || list[nbx][nby] == '#') {
							nbx -= direct[i][0];
							nby -= direct[i][1];
							break;
						}

						if (list[nbx][nby] == 'O') {
							bholl = true;
							break;
						}
					}

					if (bholl)
						continue;
					else if (rholl)
						return 1;

					if (nrx == nbx && nry == nby) {
						int nrx2 = rx;
						int nry2 = ry;
						boolean flag = true;
						while (true) {
							nrx2 += direct[i][0];
							nry2 += direct[i][1];

							if (nrx2 == bx && nry2 == by) {
								flag = false;
								break;
							}

							if (nrx2 < 0 || nry2 < 0 || nrx2 >= N || nry2 >= M || list[nrx2][nry2] == '#')
								break;
						}

						if (flag) {
							nbx -= direct[i][0];
							nby -= direct[i][1];
						} else {
							nrx -= direct[i][0];
							nry -= direct[i][1];
						}
					}

					if (visit[nrx][nry][nbx][nby])
						continue;
					visit[nrx][nry][nbx][nby] = true;
					q.addLast(new int[] { nrx, nry, nbx, nby });
				}
			}
		}

		return 0;
	}

	static void func() {
		System.out.println(bfs());
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new char[N][M];
		visit = new boolean[N][M][N][M];
		rxy = new int[2];
		bxy = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'R') {
					rxy[0] = i;
					rxy[1] = j;
				} else if (list[i][j] == 'B') {
					bxy[0] = i;
					bxy[1] = j;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}