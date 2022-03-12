package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2467 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], ans[];
	static int N, mix = Integer.MAX_VALUE;

	static void func() {
		ans = new int[2];
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int sum = Math.abs(list[l] + list[r]);
			if (sum < mix) {
				mix = sum;
				ans[0] = list[l];
				ans[1] = list[r];
			}

			if (list[l] + list[r] < 0)
				l++;
			else
				r--;
		}

		System.out.println(ans[0] + " " + ans[1]);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}