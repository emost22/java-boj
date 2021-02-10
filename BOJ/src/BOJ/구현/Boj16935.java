package BOJ.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][], calc[];
	static int N, M, R;

	static void cal1() {
		for (int i = 0, k = N - 1; i < N / 2; i++, k--) {
			for (int j = 0; j < M; j++) {
				int tmp = list[i][j];
				list[i][j] = list[k][j];
				list[k][j] = tmp;
			}
		}
	}

	static void cal2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0, k = M - 1; j < M / 2; j++, k--) {
				int tmp = list[i][j];
				list[i][j] = list[i][k];
				list[i][k] = tmp;
			}
		}
	}

	static void cal3() {
		int newlist[][] = new int[M][N];
		int x = 0;
		int y = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newlist[x][y] = list[i][j];
				x++;
			}
			x = 0;
			y--;
		}
		int tmp = N;
		N = M;
		M = tmp;

		list = newlist;
	}

	static void cal4() {
		int newlist[][] = new int[M][N];
		int x = M - 1;
		int y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newlist[x][y] = list[i][j];
				x--;
			}
			x = M - 1;
			y++;
		}
		int tmp = N;
		N = M;
		M = tmp;

		list = newlist;
	}

	static void cal5() {
		int x1 = 0, y1 = 0;
		int x2 = 0, y2 = M / 2;
		int x3 = N / 2, y3 = M / 2;
		int x4 = N / 2, y4 = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = list[x1][y1];
				list[x1][y1] = list[x4][y4];
				list[x4][y4] = list[x3][y3];
				list[x3][y3] = list[x2][y2];
				list[x2][y2] = tmp;

				y1++;
				y2++;
				y3++;
				y4++;
			}
			y1 = 0;
			y2 = M / 2;
			y3 = M / 2;
			y4 = 0;
			x1++;
			x2++;
			x3++;
			x4++;
		}
	}

	static void cal6() {
		int x1 = 0, y1 = 0;
		int x2 = 0, y2 = M / 2;
		int x3 = N / 2, y3 = M / 2;
		int x4 = N / 2, y4 = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = list[x1][y1];
				list[x1][y1] = list[x2][y2];
				list[x2][y2] = list[x3][y3];
				list[x3][y3] = list[x4][y4];
				list[x4][y4] = tmp;

				y1++;
				y2++;
				y3++;
				y4++;
			}
			y1 = 0;
			y2 = M / 2;
			y3 = M / 2;
			y4 = 0;
			x1++;
			x2++;
			x3++;
			x4++;
		}
	}

	static void func() {
		for (int i = 0; i < R; i++) {
			if (calc[i] == 1)
				cal1();
			else if (calc[i] == 2)
				cal2();
			else if (calc[i] == 3)
				cal3();
			else if (calc[i] == 4)
				cal4();
			else if (calc[i] == 5)
				cal5();
			else
				cal6();
		}
	}

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(list[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		calc = new int[R];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}