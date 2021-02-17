package BOJ.구현;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Boj1992 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static char list[][];
	static int N;

	static void func(int size, int x, int y) {
		if (size == 1) {
			sb.append(list[x][y]);
			return;
		}

		boolean chk = false;
		char ch = list[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (ch != list[i][j]) {
					chk = true;
					break;
				}
			}
			if (chk)
				break;
		}

		if (chk) {
			sb.append("(");
			func(size / 2, x, y);
			func(size / 2, x, (y + y + size) / 2);
			func(size / 2, (x + x + size) / 2, y);
			func(size / 2, (x + x + size) / 2, (y + y + size) / 2);
			sb.append(")");
		} else {
			sb.append(ch);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(N, 0, 0);
		System.out.println(sb.toString());
	}
}