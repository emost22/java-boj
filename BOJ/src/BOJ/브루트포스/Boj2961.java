package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long list[][];
	static long ans = Long.MAX_VALUE;
	static int N;

	static void func(int idx, long a, long b) {
		if (idx > 0)
			ans = Math.min(ans, Math.abs(a - b));
		
		if (idx == N)
			return;

		for (int i = idx; i < N; i++) {
			func(i + 1, a * list[i][0], b + list[i][1]);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new long[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Long.parseLong(st.nextToken());
			list[i][1] = Long.parseLong(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0, 1, 0);
		System.out.println(ans);
	}
}