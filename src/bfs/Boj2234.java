package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj2234 {
	static int N, M, roomcnt, maxarearoom;
	static int list[][] = new int[50][50];
	static int roomnumber[][] = new int[50][50];
	static int roomarea[] = new int[2501];
	static boolean visit[][] = new boolean[50][50];
	static int wall[] = { 1, 2, 4, 8 };
	static int direct[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static ArrayList<Set<Integer>> sideroom = new ArrayList<>();

	static void roomdiv(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int nowx = q.peek()[0];
			int nowy = q.peek()[1];
			q.remove();

			roomarea[roomcnt]++;
			roomnumber[nowx][nowy] = roomcnt;
			for (int i = 0; i < 4; i++) {
				int nx = nowx + direct[i][0];
				int ny = nowy + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny] || ((wall[i] & list[nowx][nowy]) != 0))
					continue;

				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		Set<Integer> s = new HashSet<>();
		q.add(new int[] { x, y });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int nowx = q.peek()[0];
			int nowy = q.peek()[1];
			q.remove();

			for (int i = 0; i < 4; i++) {
				int nx = nowx + direct[i][0];
				int ny = nowy + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny])
					continue;
				if (roomnumber[nowx][nowy] != roomnumber[nx][ny]) {
					s.add(roomnumber[nx][ny]);
					continue;
				}

				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}

		sideroom.add(s);
	}

	static void solve() {
		int ans = 0;
		for (int i = 0; i < sideroom.size(); i++) {
			Set<Integer> s = sideroom.get(i);
			for (Integer n : s) {
				ans = Math.max(ans, roomarea[i] + roomarea[n]);
			}
		}

		System.out.println(roomcnt);
		System.out.println(maxarearoom);
		System.out.println(ans);
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;
				roomdiv(i, j);
				maxarearoom = Math.max(maxarearoom, roomarea[roomcnt]);
				roomcnt++;
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;
				bfs(i, j);
			}
		}

		solve();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

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
	}
}
