package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj15653 {
	static class Pair {
		int rx;
		int ry;
		int bx;
		int by;
		int cnt;

		public Pair(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<Pair> dq = new ArrayDeque<>();
	static boolean visit[][][][] = new boolean[11][11][11][11];
	static char list[][] = new char[11][11];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M;

	static void bfs() {
		while (!dq.isEmpty()) {
			int rx = dq.peek().rx;
			int ry = dq.peek().ry;
			int bx = dq.peek().bx;
			int by = dq.peek().by;
			int cnt = dq.poll().cnt;

			for (int i = 0; i < 4; i++) {
				int nrx = rx;
				int nry = ry;
				boolean redchk = false;
				while (true) {
					nrx += direct[i][0];
					nry += direct[i][1];

					if (list[nrx][nry] == '#') {
						nrx -= direct[i][0];
						nry -= direct[i][1];
						break;
					}
					if (list[nrx][nry] == 'O') {
						redchk = true;
						break;
					}
				}

				int nbx = bx;
				int nby = by;
				boolean bluechk = false;
				while (true) {
					nbx += direct[i][0];
					nby += direct[i][1];

					if (list[nbx][nby] == '#') {
						nbx -= direct[i][0];
						nby -= direct[i][1];
						break;
					}
					if (list[nbx][nby] == 'O') {
						bluechk = true;
						break;
					}
				}

				if (bluechk)
					continue;
				else if (redchk) {
					System.out.println(cnt + 1);
					return;
				}

				if (nrx == nbx && nry == nby) {
					int reddis = Math.abs(nrx - rx) + Math.abs(nry - ry);
					int bluedis = Math.abs(nbx - bx) + Math.abs(nby - by);

					if (bluedis < reddis) {
						nrx -= direct[i][0];
						nry -= direct[i][1];
					} else {
						nbx -= direct[i][0];
						nby -= direct[i][1];
					}
				}

				if (visit[nrx][nry][nbx][nby])
					continue;

				dq.add(new Pair(nrx, nry, nbx, nby, cnt + 1));
				visit[nrx][nry][nbx][nby] = true;
			}
		}

		System.out.println(-1);
	}

	static void input() throws Exception {
		int rx = 0, ry = 0, bx = 0, by = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (list[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

		dq.add(new Pair(rx, ry, bx, by, 0));
		visit[rx][ry][bx][by] = true;
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}