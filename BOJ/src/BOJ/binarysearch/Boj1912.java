package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1912 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[];
	static int N, ans = Integer.MIN_VALUE;

	static int binarysearch(int l, int r) {
		if (l == r)
			return list[l];

		int m = (l + r) / 2;
		int leftmax = Integer.MIN_VALUE;
		int rightmax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = m; i >= l; i--) {
			sum += list[i];
			leftmax = Math.max(leftmax, sum);
		}

		sum = 0;
		for (int i = m + 1; i <= r; i++) {
			sum += list[i];
			rightmax = Math.max(rightmax, sum);
		}

		return Math.max(leftmax + rightmax, Math.max(binarysearch(l, m), binarysearch(m + 1, r)));
	}

	static void func() {
		System.out.println(binarysearch(1, N));
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}