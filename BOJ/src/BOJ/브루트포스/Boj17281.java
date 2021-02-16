package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj17281 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> order = new ArrayList<>();
	static boolean visit[];
	static int list[][];
	static int N, ans;

	static void game() {
		int ground[] = new int[4];
		int g = 0;
		int t = 0;
		int out = 0;
		while (g < N) {
			int x = list[g][order.get(t)];

			if (x == 1) {
				ground[3] += ground[2];
				ground[2] = 0;
				ground[2] += ground[1];
				ground[1] = 0;
				ground[1] += ground[0];
				ground[0] = 1;
			} else if (x == 2) {
				ground[3] += ground[2];
				ground[2] = 0;
				ground[3] += ground[1];
				ground[1] = 0;
				ground[2] += ground[0];
				ground[1] = 1;
				ground[0] = 0;
			} else if (x == 3) {
				ground[3] += ground[2];
				ground[3] += ground[1];
				ground[3] += ground[0];
				ground[1] = 0;
				ground[0] = 0;
				ground[2] = 1;
			} else if (x == 4) {
				int sum = 1;
				for (int i = 0; i <= 2; i++) {
					if (ground[i] == 1) {
						ground[i] = 0;
						sum++;
					}
				}
				ground[3] += sum;
			} else {
				out++;
				if (out == 3) {
					ground[2] = 0;
					ground[1] = 0;
					ground[0] = 0;
					out = 0;
					g++;
				}
			}
			t = (t + 1) % 9;
		}

		ans = Math.max(ans, ground[3]);
	}

	static void func(int cnt) {
		if (cnt == 9) {
			game();
			return;
		}

		if (cnt == 3) {
			order.add(0);
			func(4);
			order.remove(cnt);
		}

		for (int i = 1; i < 9; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			order.add(i);
			func(cnt + 1);
			order.remove(cnt);
			visit[i] = false;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N][9];
		visit = new boolean[10];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0);
		System.out.println(ans);
	}
}