package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<>();
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int list[][];
	static int N, M, ans;

	static void bfs() {
		Queue<int[]> nq = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		nq.addAll(q);
		Iterator<int[]> iter = nq.iterator();
		while (iter.hasNext()) {
			int xy[] = iter.next();
			visit[xy[0]][xy[1]] = true;
		}

		while (!nq.isEmpty()) {
			int x = nq.peek()[0];
			int y = nq.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny] || list[nx][ny] == 1)
					continue;

				nq.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 0 && !visit[i][j])
					cnt++;
			}
		}

		ans = Math.max(ans, cnt);
	}

	static void func(int x, int y, int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}

		int i = x;
		int j = y;
		for (; i < N; i++) {
			for (; j < M; j++) {
				if (list[i][j] != 0)
					continue;

				list[i][j] = 1;
				if (j + 1 == M)
					func(i + 1, 0, cnt + 1);
				else
					func(i, j + 1, cnt + 1);
				list[i][j] = 0;
			}
			j = 0;
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
				if (list[i][j] == 2)
					q.add(new int[] { i, j });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0, 0, 0);
		System.out.println(ans);
	}
}