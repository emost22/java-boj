package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj8972 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<int[]> dq = new ArrayDeque<>();
	static char list[][] = new char[110][110];
	static int direct[][] = { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { -1, -1 },
			{ -1, 0 }, { -1, 1 } };
	static int map[][][];
	static int move[] = new int[101];
	static int N, M, ix, iy, movecnt;

	static void func() {
		int m = 0;
		for (int t = 0; t < movecnt; t++) {
			int nx = ix + direct[move[t]][0];
			int ny = iy + direct[move[t]][1];

			if (map[1 - m][nx][ny] == 1) {
				System.out.println("kraj " + (t + 1));
				return;
			}

			ix = nx;
			iy = ny;

			int size = dq.size();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					map[m][i][j] = 0;
			}
			for (int i = 1; i <= size; i++) {
				int rx = dq.peek()[0];
				int ry = dq.poll()[1];
				if (map[1 - m][rx][ry] == 0) {
					continue;
				}

				int mindis = Integer.MAX_VALUE;
				int minidx = -1;
				for (int j = 1; j <= 9; j++) {
					if (j == 5)
						continue;
					nx = rx + direct[j][0];
					ny = ry + direct[j][1];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					int dis = Math.abs(nx - ix) + Math.abs(ny - iy);
					if (mindis > dis) {
						minidx = j;
						mindis = dis;
					}
				}
				nx = rx + direct[minidx][0];
				ny = ry + direct[minidx][1];
				if (nx == ix && ny == iy) {
					System.out.println("kraj " + (t + 1));
					return;
				}

				dq.add(new int[] { nx, ny });
				map[m][nx][ny]++;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[m][i][j] > 1)
						map[m][i][j] = 0;
				}
			}
			m = 1 - m;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[1 - m][i][j] > 0)
					sb.append('R');
				else if (i == ix && j == iy)
					sb.append('I');
				else
					sb.append('.');
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[2][N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'R') {
					dq.add(new int[] { i, j, 0 });
					map[1][i][j] = 1;
				} else if (list[i][j] == 'I') {
					ix = i;
					iy = j;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		String str[] = st.nextToken().split("");
		for (int i = 0; i < str.length; i++) {
			move[i] = Integer.parseInt(str[i]);
		}
		movecnt = str.length;
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}