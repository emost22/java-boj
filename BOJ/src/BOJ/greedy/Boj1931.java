package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1931 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][];
	static int N, ans = 1;

	static void func() {
		int e = list[0][1];
		for (int i = 1; i < N; i++) {
			if (e <= list[i][0]) {
				e = list[i][1];
				ans++;
			}
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1] == b[1]) {
					if (a[0] < b[0])
						return -1;
					else
						return 1;
				} else {
					if (a[1] < b[1])
						return -1;
					else
						return 1;
				}
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}