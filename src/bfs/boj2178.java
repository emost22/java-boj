package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair2 {
	int x;
	int y;
	int cnt;
}

public class boj2178 {
	static int N, M, ans;
	static char list[][] = new char[101][101];
	static boolean visit[][] = new boolean[101][101];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
		}
	}

	static void bfs() {
		Queue<Pair2> q = new LinkedList<>();

		Pair2 p = new Pair2();
		Pair2 np = null;
		p.x = 0;
		p.y = 0;
		p.cnt = 1;
		visit[0][0] = true;

		q.add(p);
		while (!q.isEmpty()) {
			p = q.peek();
			q.remove();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + direct[i][0];
				int ny = p.y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (list[nx][ny] == '0' || visit[nx][ny])
					continue;

				if (nx == N - 1 && ny == M - 1) {
					ans = p.cnt + 1;
					return;
				}

				np = new Pair2();
				np.x = nx;
				np.y = ny;
				np.cnt = p.cnt + 1;
				q.add(np);
				visit[nx][ny] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
		System.out.println(ans);
	}
}
