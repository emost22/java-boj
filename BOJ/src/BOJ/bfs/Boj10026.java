package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean visit[][];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static char list[][];
	static int N;

	static void bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sx, sy });
		visit[sx][sy] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (visit[nx][ny] || list[x][y] != list[nx][ny])
					continue;

				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void func() {
		int ansFirst = 0;
		int ansSecond = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;
				bfs(i, j);
				ansFirst++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = false;
				if (list[i][j] == 'G')
					list[i][j] = 'R';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;
				bfs(i, j);
				ansSecond++;
			}
		}

		System.out.println(ansFirst + " " + ansSecond);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new char[N][N];
		visit = new boolean[N][N];

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