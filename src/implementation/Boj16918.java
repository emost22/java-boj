package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj16918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<int[]> dq = new ArrayDeque<>();
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static char list[][];
	static int time[][];
	static int N, M, K;

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(list[i][j]);
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void bfs() {
		while (!dq.isEmpty()) {
			int x = dq.peekFirst()[0];
			int y = dq.pollFirst()[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = x + direct[k][0];
				int ny = y + direct[k][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				time[nx][ny] = 0;
				list[nx][ny] = '.';
			}
		}
	}

	static void func() {
		for (int t = 1; t <= K; t++) {
			if (t % 2 != 0) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (time[i][j] == 0) {
							list[i][j] = 'O';
							time[i][j] = 3;
						} else
							time[i][j]--;
					}
				}
			} else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (time[i][j] == 0)
							continue;
						time[i][j]--;
						if (time[i][j] == 0) {
							list[i][j] = '.';
							dq.addLast(new int[] { i, j });
						}
					}
				}

				bfs();
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 1;
		time = new int[N][M];
		list = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'O') {
					time[i][j] = 2;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}