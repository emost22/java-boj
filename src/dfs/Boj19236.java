package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj19236 {
	static class Pair {
		int x, y, d;

		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };
	static boolean eat[] = new boolean[17];
	static int ans;

	static void func(int[][] arr, Pair[] f, int X, int Y, int D, int S) {
		ans = Math.max(ans, S);
		for (int i = 1; i <= 16; i++) {
			if (eat[i])
				continue;

			int x = f[i].x;
			int y = f[i].y;

			int nx = x;
			int ny = y;

			while (true) {
				nx = x + direct[f[i].d][0];
				ny = y + direct[f[i].d][1];

				if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
					f[i].d = (f[i].d + 1) % 8;
					continue;
				}
				if (arr[nx][ny] == -1) {
					f[i].d = (f[i].d + 1) % 8;
					continue;
				}

				if (arr[nx][ny] == 0) {
					f[i].x = nx;
					f[i].y = ny;
					arr[nx][ny] = arr[x][y];
					arr[x][y] = 0;
				} else {
					int tmp = arr[x][y];
					f[arr[nx][ny]].x = x;
					f[arr[nx][ny]].y = y;
					f[i].x = nx;
					f[i].y = ny;
					arr[x][y] = arr[nx][ny];
					arr[nx][ny] = tmp;
				}
				break;
			}
		}

		int nx = X;
		int ny = Y;
		while (true) {
			nx = nx + direct[D][0];
			ny = ny + direct[D][1];

			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
				break;
			if (arr[nx][ny] == 0)
				continue;

			int tmp = arr[nx][ny];
			arr[nx][ny] = -1;
			arr[X][Y] = 0;
			eat[tmp] = true;
			int arr2[][] = new int[4][4];
			for (int i = 0; i < 4; i++)
				arr2[i] = arr[i].clone();
			Pair f2[] = new Pair[17];
			for (int i = 1; i <= 16; i++)
				f2[i] = new Pair(f[i].x, f[i].y, f[i].d);
			func(arr2, f2, nx, ny, f[tmp].d, S + tmp);
			eat[tmp] = false;
			arr[nx][ny] = tmp;
			arr[X][Y] = -1;
		}
	}

	public static void main(String[] args) throws Exception {
		int list[][] = new int[4][4];
		Pair fish[] = new Pair[17];

		int nowx = 0, nowy = 0, nowd = 0, sum = 0;
		int x, d;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {

				x = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken()) - 1;

				list[i][j] = x;
				fish[x] = new Pair(i, j, d);
				if (i == 0 && j == 0) {
					list[i][j] = -1;
					eat[x] = true;
					nowx = i;
					nowy = j;
					nowd = d;
					sum += x;
				}
			}
		}
		func(list, fish, nowx, nowy, nowd, sum);
		System.out.println(ans);
	}
}