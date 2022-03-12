package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2636 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int list[][];
	static boolean visit[][];
	static int N, M, now, cnt;

	static void func() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 0)
					continue;

				for (int k = 0; k < 4; k++) {
					int nx = i + direct[k][0];
					int ny = j + direct[k][1];

					if (!visit[nx][ny])
						continue;

					cnt++;
					list[i][j] = 0;
					break;
				}
			}
		}
	}

	static void bfs() {
		visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visit[0][0] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.remove();

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny] || list[nx][ny] == 1)
					continue;

				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if (list[i][j] == 1)
					now++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		for (int T = 1;; T++) {
			bfs();
			func();
			if (now == cnt) {
				System.out.println(T + "\n" + now);
				break;
			}
			now -= cnt;
			cnt = 0;
		}
	}
}