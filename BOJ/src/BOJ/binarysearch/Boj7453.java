package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj7453 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][], N;
	static long sumlist[][], ans;

	static int upperbound(int l, int r, long x) {
		while (l < r) {
			int m = (l + r) / 2;
			if (sumlist[1][m] <= x)
				l = m + 1;
			else
				r = m;
		}

		return l;
	}

	static int lowerbound(int l, int r, long x) {
		while (l < r) {
			int m = (l + r) / 2;
			if (sumlist[1][m] < x)
				l = m + 1;
			else
				r = m;
		}

		return r;
	}

	static void binarysearch(int l, int r, long x) {
		if (l > r)
			return;

		int m = (l + r) / 2;
		if (sumlist[1][m] + x == 0) {
			ans += (upperbound(0, N * N, sumlist[1][m]) - lowerbound(0, N * N, sumlist[1][m]));
			return;
		} else if (sumlist[1][m] + x < 0)
			binarysearch(m + 1, r, x);
		else
			binarysearch(l, m - 1, x);
	}

	static void func() {
		Arrays.sort(sumlist[1]);
		for (int i = 0; i < N * N; i++) {
			binarysearch(0, N * N - 1, sumlist[0][i]);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[4][N];
		sumlist = new long[2][N * N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[0][i] = Integer.parseInt(st.nextToken());
			list[1][i] = Integer.parseInt(st.nextToken());
			list[2][i] = Integer.parseInt(st.nextToken());
			list[3][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0, k = 0; i < N; i++) {
			for (int j = 0; j < N; j++, k++) {
				sumlist[0][k] = list[0][i] + list[1][j];
				sumlist[1][k] = list[2][i] + list[3][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.println(ans);
	}
}