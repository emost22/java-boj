package BOJ.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20361 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int list[], change[][];
	static int N, X, K, ans;

	static void func() {
		for (int i = 0; i < K; i++) {
			int x = change[i][0];
			int y = change[i][1];

			int tmp = list[x];
			list[x] = list[y];
			list[y] = tmp;

			if (list[x] == 1)
				ans = x;
			else if (list[y] == 1)
				ans = y;
		}

		sb.append(ans + "\n");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N + 1];
		change = new int[K][2];

		list[X] = 1;
		ans = X;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			change[i][0] = Integer.parseInt(st.nextToken());
			change[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.println(sb.toString());
	}
}