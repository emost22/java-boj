package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11559 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static char list[][] = new char[12][6];
	static ArrayList<int[]> er = new ArrayList<>();
	static int ans, cnt;

	static void bfs(int sx, int sy) {
		boolean visit[][] = new boolean[12][6];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sx, sy });
		visit[sx][sy] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			er.add(new int[] { x, y });
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6)
					continue;
				if (visit[nx][ny] || list[x][y] != list[nx][ny])
					continue;

				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}
	}

	static void func() {
		while (true) {
			boolean chk = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (list[i][j] == '.')
						continue;

					bfs(i, j);
					if (cnt >= 4) {
						chk = true;
						for (int x[] : er) {
							list[x[0]][x[1]] = '.';
						}
					}

					er.clear();
					cnt = 0;
				}
			}

			if (chk)
				ans++;
			else
				break;

			for (int i = 10; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (list[i][j] == '.')
						continue;

					if (list[i + 1][j] == '.') {
						int idx = i + 1;
						for (int k = i + 1; k < 12; k++) {
							if (list[k][j] == '.')
								idx = k;
							else
								break;
						}

						char tmp = list[i][j];
						list[i][j] = list[idx][j];
						list[idx][j] = tmp;
					}
				}
			}
		}
		
		System.out.println(ans);
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