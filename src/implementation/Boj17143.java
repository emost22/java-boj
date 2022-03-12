package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17143 {
	static class Pair {
		int speed;
		int d;
		int size;

		public Pair(int speed, int d, int size) {
			this.speed = speed;
			this.d = d;
			this.size = size;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Pair list[][] = new Pair[101][101];
	static int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M, sharkCnt, ans;

	static Pair[][] moveShark() {
		Pair tmp[][] = new Pair[101][101];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				tmp[i][j] = new Pair(0, 0, 0);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (list[i][j].size > 0) {
					int dis = list[i][j].speed;
					int d = list[i][j].d;
					int size = list[i][j].size;

					if (d > 1)
						dis %= ((M - 1) * 2);
					else
						dis %= ((N - 1) * 2);

					int nx = i;
					int ny = j;
					for (int k = 0; k < dis; k++) {
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

					if (tmp[nx][ny].size == 0) {
						tmp[nx][ny].speed = list[i][j].speed;
						tmp[nx][ny].d = d;
						tmp[nx][ny].size = size;
					} else {
						if (tmp[nx][ny].size < size) {
							tmp[nx][ny].speed = list[i][j].speed;
							tmp[nx][ny].d = d;
							tmp[nx][ny].size = size;
						}
					}
				}
			}
		}

		return tmp;
	}

	static void func() {
		for (int j = 1; j <= M; j++) {
			for (int i = 1; i <= N; i++) {
				if (list[i][j].size > 0) {
					ans += list[i][j].size;
					list[i][j].speed = 0;
					list[i][j].d = 0;
					list[i][j].size = 0;
					break;
				}
			}
			if (j == M)
				break;

			list = moveShark();
		}

		System.out.println(ans);
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				list[i][j] = new Pair(0, 0, 0);
		}
	}

	static void input() throws Exception {
		int x, y, s, d, z;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharkCnt = Integer.parseInt(st.nextToken());
		init();
		for (int i = 0; i < sharkCnt; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			list[x][y].speed = s;
			list[x][y].d = d - 1;
			list[x][y].size = z;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}