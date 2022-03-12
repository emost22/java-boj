package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10157 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean visit[][];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, K;

	static void func() {
		if (K > N * M) {
			System.out.println(0);
			return;
		}

		int x = 0;
		int y = 0;
		int idx = 0;
		for (int k = 1; k <= N * M; k++) {
			visit[x][y] = true;
			if (k == K) {
				System.out.println((x + 1) + " " + (y + 1));
				return;
			}

			int nx = x + direct[idx][0];
			int ny = y + direct[idx][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) {
				idx = (idx + 1) % 4;
				nx = x + direct[idx][0];
				ny = y + direct[idx][1];
			}

			x = nx;
			y = ny;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}