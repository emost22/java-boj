package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj5427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Deque<int[]> dq = new ArrayDeque<>();
	static Deque<int[]> firedq = new ArrayDeque<>();
	static char list[][] = new char[1010][1010];
	static boolean visit[][] = new boolean[1010][1010];
	static boolean fvisit[][] = new boolean[1010][1010];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean chk;
	static int N, M;

	static void firebfs() {
		int size = firedq.size();
		while (size-- > 0) {
			int x = firedq.peek()[0];
			int y = firedq.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (fvisit[nx][ny] || list[nx][ny] == '#')
					continue;

				firedq.add(new int[] { nx, ny });
				fvisit[nx][ny] = true;
			}
		}
	}

	static void bfs() {
		int size = dq.size();
		while (size-- > 0) {
			int x = dq.peek()[0];
			int y = dq.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					chk = true;
					return;
				}
				if (visit[nx][ny] || list[nx][ny] == '#' || fvisit[nx][ny])
					continue;

				dq.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void func() {
		for (int t = 1;; t++) {
			firebfs();
			bfs();

			if (chk) {
				chk = false;
				sb.append(t).append("\n");
				return;
			}
			if (dq.isEmpty()) {
				sb.append("IMPOSSIBLE\n");
				return;
			}
		}
	}

	static void clear() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
			Arrays.fill(fvisit[i], false);
		}
		dq.clear();
		firedq.clear();
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (list[i][j] == '@') {
					visit[i][j] = true;
					dq.add(new int[] { i, j });
				} else if (list[i][j] == '*') {
					fvisit[i][j] = true;
					firedq.add(new int[] { i, j });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			func();
			clear();
		}
		
		System.out.println(sb.toString());
	}
}