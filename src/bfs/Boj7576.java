package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<int[]> dq = new ArrayDeque<>();
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean visit[][];
	static int list[][];
	static int N, M, ans;

	static void bfs() {
		int t = 1;
		for (; !dq.isEmpty(); t++) {
			int size = dq.size();

			while (size-- > 0) {
				int x = dq.peekFirst()[0];
				int y = dq.pollFirst()[1];

				for (int i = 0; i < 4; i++) {
					int nx = x + direct[i][0];
					int ny = y + direct[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if (list[nx][ny] == -1 || visit[nx][ny])
						continue;
 
					visit[nx][ny] = true;
					dq.addLast(new int[] { nx, ny });
					ans--;
				}
			}

			if (ans == 0)
				break;
		}
		if (ans == 0)
			System.out.println(t);
		else
			System.out.println(-1);
	}

	static void func() {
		if (ans == 0) {
			System.out.println(0);
			return;
		}

		bfs();
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if (list[i][j] == 0)
					ans++;
				else if (list[i][j] == 1) {
					dq.addLast(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}