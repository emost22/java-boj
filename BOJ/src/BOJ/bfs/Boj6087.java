package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj6087 {
	static class Pair {
		int x;
		int y;
		int d;
		int cnt;

		public Pair(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<Pair> dq = new ArrayDeque<>();
	static char list[][] = new char[101][101];
	static int dis[][] = new int[101][101];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, ex, ey;

	static void bfs() {
		while (!dq.isEmpty()) {
			int x = dq.peek().x;
			int y = dq.peek().y;
			int d = dq.peek().d;
			int cnt = dq.poll().cnt;

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];
				int ncnt = cnt;
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (list[nx][ny] == '*')
					continue;
				if (d != i)
					ncnt++;
				if (dis[nx][ny] < ncnt)
					continue;

				dq.add(new Pair(nx, ny, i, ncnt));
				dis[nx][ny] = ncnt;
			}
		}
		
		System.out.println(dis[ex][ey]);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'C') {
					if (dq.isEmpty()) {
						dq.add(new Pair(i, j, 0, 0));
						dq.add(new Pair(i, j, 1, 0));
						dq.add(new Pair(i, j, 2, 0));
						dq.add(new Pair(i, j, 3, 0));
						dis[i][j] = 0;
					} else {
						ex = i;
						ey = j;
						dis[i][j] = Integer.MAX_VALUE;
					}
				}
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}