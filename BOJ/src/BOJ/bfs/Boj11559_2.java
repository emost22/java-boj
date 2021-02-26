package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj11559_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char list[][] = new char[12][6];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static ArrayList<int[]> erasepoint = new ArrayList<>();
	static boolean visit[][] = new boolean[12][6];
	static int cnt;

	static void bfs(int sx, int sy) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { sx, sy });
		visit[sx][sy] = true;
		cnt = 0;
		while (!dq.isEmpty()) {
			int x = dq.peek()[0];
			int y = dq.poll()[1];
			erasepoint.add(new int[] { x, y });
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6)
					continue;
				if (visit[nx][ny] || list[nx][ny] != list[x][y])
					continue;

				dq.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void func() {
		for (int t = 1;; t++) {
			boolean chk = false;
			for (int i = 0; i < 12; i++)
				Arrays.fill(visit[i], false);

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (list[i][j] == '.')
						continue;
					bfs(i, j);
					if (cnt >= 4) {
						chk = true;
						for (int xy[] : erasepoint) {
							list[xy[0]][xy[1]] = '.';
						}
					}
					erasepoint.clear();
				}
			}

			if (!chk) {
				System.out.println(t - 1);
				return;
			}

			for (int i = 10; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (list[i][j] == '.')
						continue;

					for (int k = i + 1; k < 12; k++) {
						if (list[k][j] != '.') {
							char tmp = list[i][j];
							list[i][j] = list[k - 1][j];
							list[k - 1][j] = tmp;
							break;
						} else {
							if (k == 11) {
								char tmp = list[i][j];
								list[i][j] = list[k][j];
								list[k][j] = tmp;
								break;
							}
						}
					}
				}
			}
		}
	}

	static void input() throws Exception {
		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}