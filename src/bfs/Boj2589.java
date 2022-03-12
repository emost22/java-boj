package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2589 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char list[][] = new char[60][60];
	static boolean visit[][] = new boolean[60][60];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, ans;

	static void bfs(int sx, int sy) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { sx, sy, 0 });
		visit[sx][sy] = true;
		while (!dq.isEmpty()) {
			int x = dq.peek()[0];
			int y = dq.peek()[1];
			int cnt = dq.poll()[2];

			ans = Math.max(ans, cnt);
			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny] || list[nx][ny] == 'W')
					continue;

				dq.add(new int[] { nx, ny, cnt + 1 });
				visit[nx][ny] = true;
			}
		}
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'W')
					continue;

				bfs(i, j);
				for (int k = 0; k < N; k++)
					Arrays.fill(visit[k], false);
			}
		}
		
		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

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