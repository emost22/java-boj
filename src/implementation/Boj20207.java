package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20207 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[] = new int[366];
	static int N, ans;

	static void func() {
		int max = 0;
		int con = 0;
		for (int i = 1; i <= 365; i++) {
			if (list[i] > 0) {
				con++;
				max = Math.max(max, list[i]);
			} else {
				ans += (con * max);
				con = 0;
				max = 0;
			}
		}

		ans += (con * max);
		System.out.println(ans);
	}

	static void input() throws Exception {
		int l, r;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			for (int j = l; j <= r; j++)
				list[j]++;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}