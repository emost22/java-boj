package BOJ.bfs;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Boj16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<>();
	static boolean visit[][];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int list[][];
	static int N, ans;

	static void bfs() {
		ArrayList<int[]> fish = new ArrayList<>();
		int size = 2;
		int eat = 0;
		while (true) {
			boolean chk = false;
			int mindis = -1;
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				int dis = q.poll()[2];
				if (dis == mindis)
					break;

				for (int i = 0; i < 4; i++) {
					int nx = x + direct[i][0];
					int ny = y + direct[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (size < list[nx][ny] || visit[nx][ny])
						continue;

					if (list[nx][ny] != 0 && size > list[nx][ny]) {
						mindis = dis + 1;
						fish.add(new int[] { nx, ny, dis + 1 });
						chk = true;
					} else {
						q.add(new int[] { nx, ny, dis + 1 });
						visit[nx][ny] = true;
					}
				}
			}

			if (!chk)
				break;

			Collections.sort(fish, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					if (a[2] != b[2])
						return a[2] - b[2];
					else if (a[0] != b[0])
						return a[0] - b[0];
					else
						return a[1] - b[1];
				}
			});

			int X = fish.get(0)[0];
			int Y = fish.get(0)[1];
			ans += fish.get(0)[2];
			list[X][Y] = 0;
			q.clear();
			fish.clear();
			for (int i = 0; i < N; i++)
				Arrays.fill(visit[i], false);

			eat++;
			if (eat == size) {
				size++;
				eat = 0;
			}
			q.add(new int[] { X, Y, 0 });
			visit[X][Y] = true;
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if (list[i][j] == 9) {
					list[i][j] = 0;
					q.add(new int[] { i, j, 0 });
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