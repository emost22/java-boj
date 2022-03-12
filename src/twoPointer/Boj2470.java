package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2470 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[];
	static int ans[] = new int[2];
	static int N;

	static void func() {
		int mix = Integer.MAX_VALUE;
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int sum = list[l] + list[r];
			if (mix > Math.abs(sum)) {
				mix = Math.abs(sum);
				ans[0] = list[l];
				ans[1] = list[r];
			}

			if (sum < 0)
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