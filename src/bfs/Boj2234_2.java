package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj2234_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][] = new int[51][51];
	static int div[][] = new int[51][51];
	static boolean visit[][] = new boolean[51][51];
	static ArrayList<Integer> roomarea = new ArrayList<>();
	static Set<Integer> s[];
	static int wall[] = { 4, 8, 1, 2 };
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, roomcnt, maxarea, cnt, ans;

	static void sidechk(int sx, int sy) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { sx, sy });
		visit[sx][sy] = true;
		while (!dq.isEmpty()) {
			int x = dq.peek()[0];
			int y = dq.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny])
					continue;

				if (div[x][y] != div[nx][ny])
					s[div[x][y]].add(div[nx][ny]);
				else {
					dq.add(new int[] { nx, ny });
					visit[nx][ny] = true;
				}
			}
		}
	}

	static void solveroom(int sx, int sy) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { sx, sy });
		visit[sx][sy] = true;
		while (!dq.isEmpty()) {
			int x = dq.peek()[0];
			int y = dq.poll()[1];
			div[x][y] = roomcnt;
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny] || (wall[i] & list[x][y]) > 0)
					continue;

				dq.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;
				solveroom(i, j);
				roomarea.add(cnt);
				roomcnt++;
				maxarea = Math.max(maxarea, cnt);
				cnt = 0;
			}
		}

		s = new HashSet[roomcnt];
		for (int i = 0; i < roomcnt; i++)
			s[i] = new HashSet<>();

		for (int i = 0; i < N; i++)
			Arrays.fill(visit[i], false);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;

				sidechk(i, j);
			}
		}
	}

	static void solve() {
		for (int i = 0; i < roomcnt; i++) {
			Iterator<Integer> iter = s[i].iterator();
			while (iter.hasNext()) {
				ans = Math.max(ans, roomarea.get(i) + roomarea.get(iter.next()));
			}
		}

		System.out.println(roomcnt + "\n" + maxarea + "\n" + ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		solve();
	}
}