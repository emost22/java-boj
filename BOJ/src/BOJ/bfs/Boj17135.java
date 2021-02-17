package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj17135 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean visit[][];
	static int direct[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static int list[][], copylist[][], attacker[], rkill[][];
	static int N, M, D, ans, kidx;

	static void bfs() {
		int n = N;
		int sum = 0;
		Deque<int[]> dq = new ArrayDeque<int[]>();
		ArrayList<int[]> kill = new ArrayList<>();
		while (true) {
			for (int k = 0; k < 3; k++) {
				dq.addLast(new int[] { n, attacker[k], 0 });
				for (int i = 0; i < n; i++)
					Arrays.fill(visit[i], false);

				while (!dq.isEmpty()) {
					int x = dq.peekFirst()[0];
					int y = dq.peekFirst()[1];
					int cnt = dq.pollFirst()[2];

					if (cnt == D) {
						dq.clear();
						break;
					}
					boolean chk = false;
					for (int i = 0; i < 3; i++) {
						int nx = x + direct[i][0];
						int ny = y + direct[i][1];

						if (nx < 0 || ny < 0 || nx >= n || ny >= M)
							continue;
						if (visit[nx][ny])
							continue;
						if (copylist[nx][ny] == 1) {
							chk = true;
							kill.add(new int[] { nx, ny, cnt + 1 });
							break;
						} else {
							dq.addLast(new int[] { nx, ny, cnt + 1 });
							visit[nx][ny] = true;
						}
					}
					if (chk)
						break;
				}
				dq.clear();

				if (kill.isEmpty())
					continue;

				rkill[kidx][0] = kill.get(0)[0];
				rkill[kidx++][1] = kill.get(0)[1];
				kill.clear();
			}

			for (int i = 0; i < kidx; i++) {
				if (copylist[rkill[i][0]][rkill[i][1]] == 1) {
					copylist[rkill[i][0]][rkill[i][1]] = 0;
					sum++;
				}
			}
			kidx = 0;

			boolean allkill = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < M; j++) {
					if (copylist[i][j] == 1) {
						allkill = true;
						break;
					}
				}
				if (allkill)
					break;
			}
			if (!allkill)
				break;
			n--;
		}

		ans = Math.max(ans, sum);
	}

	static void func(int idx, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					copylist[i][j] = list[i][j];
			}
			bfs();
			return;
		}

		for (int i = idx; i < M; i++) {
			attacker[cnt] = i;
			func(i + 1, cnt + 1);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		copylist = new int[N][M];
		attacker = new int[3];
		visit = new boolean[N][M];
		rkill = new int[226][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0, 0);
		System.out.println(ans);
	}
}