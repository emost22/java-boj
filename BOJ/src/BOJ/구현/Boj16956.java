package BOJ.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16956 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static char list[][];
	static int N, M;
	static boolean chk;

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
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (list[i][j] == 'S') {
					for (int k = 0; k < 4; k++) {
						int nx = i + direct[k][0];
						int ny = j + direct[k][1];

						if (nx < 0 || ny < 0 || nx >= N || ny >= M)
							continue;
						if (list[nx][ny] == 'S' || list[nx][ny] == 'D')
							continue;
						if (list[nx][ny] == 'W') {
							chk = true;
							return;
						}

						list[nx][ny] = 'D';
					}
				}
			}
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
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}