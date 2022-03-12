package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16956 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<>();
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean chk;
	static char list[][];
	static int N, M;

	static void print() {
		if (chk) {
			System.out.println(0);
			return;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("1\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(list[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void func() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.remove();

			for (int i = 0; i < 4; i++) {
				int nx = x + direct[i][0];
				int ny = y + direct[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (list[nx][ny] == 'S' || list[nx][ny] == 'D')
					continue;
				if (list[nx][ny] == 'W') {
					chk = true;
					break;
				}

				list[nx][ny] = 'D';
			}

			if (chk)
				break;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'S') {
					q.add(new int[] { i, j });
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