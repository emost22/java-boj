package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17143_2 {
	static class Pair {
		int idx;
		int x;
		int y;
		int speed;
		int d;
		int size;
		boolean die;

		public Pair(int idx, int x, int y, int speed, int d, int size) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.d = d;
			this.size = size;
			this.die = false;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int newlist[][] = new int[101][101];
	static int list[][] = new int[101][101];
	static Pair shark[] = new Pair[10001];
	static int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M, sharkCnt, ans;

	static void moveShark() {
		for (int i = 1; i <= N; i++)
			Arrays.fill(newlist[i], 0);

		for (int i = 1; i <= sharkCnt; i++) {
			int x = shark[i].x;
			int y = shark[i].y;
			int speed = shark[i].speed;
			int d = shark[i].d;
			int size = shark[i].size;
			boolean die = shark[i].die;

			if (die)
				continue;

			if (d > 1)
				speed %= ((M - 1) * 2);
			else
				speed %= ((N - 1) * 2);

			int nx = x;
			int ny = y;
			for (int k = 0; k < speed; k++) {
				if (nx == 1 && d == 0)
					d = 1;
				else if (nx == N && d == 1)
					d = 0;
				else if (ny == 1 && d == 3)
					d = 2;
				else if (ny == M && d == 2)
					d = 3;

				nx += direct[d][0];
				ny += direct[d][1];
			}
			shark[i].d = d;

			if (newlist[nx][ny] == 0) {
				newlist[nx][ny] = i;
				shark[i].x = nx;
				shark[i].y = ny;
			} else {
				int idx = newlist[nx][ny];
				int presize = shark[idx].size;
				if (presize < size) {
					shark[idx].die = true;
					newlist[nx][ny] = i;
					shark[i].x = nx;
					shark[i].y = ny;
				} else {
					shark[i].die = true;
				}
			}
		}
	}

	static void func() {
		for (int j = 1; j <= M; j++) {
			for (int i = 1; i <= N; i++) {
				if (list[i][j] > 0) {
					int idx = list[i][j];
					ans += shark[idx].size;
					shark[idx].die = true;
					list[i][j] = 0;
					break;
				}
			}
			if (j == M)
				break;

			moveShark();
			for (int x = 1; x <= N; x++)
				for (int y = 1; y <= M; y++)
					list[x][y] = newlist[x][y];
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		int x, y, s, d, z;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharkCnt = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= sharkCnt; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			shark[i] = new Pair(i, x, y, s, d - 1, z);
			list[x][y] = i;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}