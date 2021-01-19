package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[];
	static int ques[];
	static int N, M;

	static int binarysearch(int l, int r, int x) {
		if (l > r)
			return 0;

		int m = (l + r) / 2;
		if (list[m] == x)
			return 1;
		else {
			if (list[m] > x)
				return binarysearch(l, m - 1, x);
			else
				return binarysearch(m + 1, r, x);
		}
	}

	static void func() {
		for (int i = 1; i <= M; i++) {
			System.out.println(binarysearch(1, N, ques[i]));
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		ques = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			ques[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}