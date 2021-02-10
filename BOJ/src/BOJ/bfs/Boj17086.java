package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17086 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<>();
	static int direct[][] = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	static boolean visit[][];
	static int list[][];
	static int N, M;

	static void bfs() {
		int ans = 0;
		while (!q.isEmpty()) {
			ans++;
			int size = q.size();

			while (size-- > 0) {
				int x = q.peek()[0];
				int y = q.poll()[1];

				for (int i = 0; i < 8; i++) {
					int nx = x + direct[i][0];
					int ny = y + direct[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if (visit[nx][ny])
						continue;

					q.add(new int[] { nx, ny });
					visit[nx][ny] = true;
				}
			}
		}

		System.out.println(ans - 1);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if (list[i][j] == 1) {
					q.add(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}