package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2805 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[];
	static int N, M, maxheight;
	static long ans = 0;

	static void binarysearch(long l, long r) {
		if (l > r)
			return;

		long m = (l + r) / 2;
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			if (list[i] <= m)
				continue;
			sum += (list[i] - m);
		}

		if (sum >= M) {
			ans = Math.max(ans, m);
			binarysearch(m + 1, r);
		} else {
			binarysearch(l, m - 1);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			maxheight = Math.max(maxheight, list[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		binarysearch(1, maxheight);
		System.out.println(ans);
	}
}