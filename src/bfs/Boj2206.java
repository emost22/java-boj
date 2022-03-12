package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<>();
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean visit[][][];
	static char list[][];
	static int N, M, ans = -1;

	static void bfs() {
		q.add(new int[] { 0, 0, 1, 0 });
		visit[0][0][0] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			int broke = q.poll()[3];

			if (x == N - 1 && y == M - 1) {
				ans = cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (list[nx][ny] == '1' && broke == 1)
					continue;

				if (list[nx][ny] == '1') {
					if (visit[nx][ny][1])
						continue;
					q.add(new int[] { nx, ny, cnt + 1, 1 });
					visit[nx][ny][1] = true;
				} else {
					if (visit[nx][ny][broke])
						continue;
					q.add(new int[] { nx, ny, cnt + 1, broke });
					visit[nx][ny][broke] = true;
				}
			}
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new char[N][];
		visit = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}