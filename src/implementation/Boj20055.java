package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20055 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][];
	static int N, K, ans;

	static void func() {
		int l = 1;
		int r = N;
		for (int t = 1;; t++) {
			l--;
			r--;
			if (l == 0)
				l = 2 * N;
			if (r == 0)
				r = 2 * N;

			for (int i = r;; i--) {
				if (i == 0)
					i = 2 * N;
				if (i == r) {
					list[i][1] = 0;
					continue;
				}
				int next = i + 1;
				if (next == 2 * N + 1)
					next = 1;

				if (list[i][1] == 0) {
					if (i == l)
						break;
					continue;
				}
				if (list[next][0] == 0 || list[next][1] == 1) {
					if (i == l)
						break;
					continue;
				}

				if (next != r)
					list[next][1] = 1;
				list[i][1] = 0;
				list[next][0]--;

				if (list[next][0] == 0)
					ans++;

				if (i == l)
					break;
			}

			if (list[l][0] > 0) {
				list[l][1] = 1;
				list[l][0]--;
				if (list[l][0] == 0)
					ans++;
			}

			if (ans >= K) {
				System.out.println(t);
				break;
			}
		}
	}

	static void input() throws Exception {
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[2 * N + 1][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2 * N; i++) {
			list[i][0] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}