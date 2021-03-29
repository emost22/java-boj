package BOJ.floyd;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Boj11265 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int list[][] = new int[501][501];
	static int N, M;

	static void func() throws Exception {
		int a, b, c;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (list[a][b] <= c)
				sb.append("Enjoy other party\n");
			else
				sb.append("Stay here\n");
		}
		
		System.out.println(sb.toString());
	}

	static void init() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					list[i][j] = Math.min(list[i][j], list[i][k] + list[k][j]);
				}
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		init();
		func();
	}
}