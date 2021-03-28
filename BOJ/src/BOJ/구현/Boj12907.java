package BOJ.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12907 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[] = new int[40];
	static int cnt[] = new int[40];
	static int N, twocnt, onecnt;

	static void solve() {
		if (cnt[0] == 0 || cnt[0] > 2) {
			System.out.println(0);
			return;
		}

		int tmp = cnt[0];
		if (tmp == 2)
			twocnt++;
		else if(tmp == 1)
			onecnt++;

		for (int i = 1; i < N; i++) {
			if (tmp < cnt[i] || cnt[i] > 2) {
				System.out.println(0);
				return;
			}

			if (cnt[i] == 2) {
				twocnt++;
			} else if (cnt[i] == 1) {
				onecnt++;
			}

			tmp = cnt[i];
		}

		twocnt = onecnt > 0 ? twocnt + 1 : twocnt;
		System.out.println((1 << twocnt));
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			int x = list[i];
			if (x >= N) {
				System.out.println(0);
				return;
			}

			cnt[x]++;
		}
		solve();
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}