package BOJ.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1517 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], sorted[];
	static int N;
	static long ans;

	static void mergesort(int l, int m, int r) {
		int i = l;
		int k = l;
		int j = m + 1;

		while (i <= m && j <= r) {
			if (list[i] <= list[j]) {
				sorted[k] = list[i];
				i++;
			} else {
				if (list[k] != list[j])
					ans += (j - k);
				sorted[k] = list[j];
				j++;
			}
			k++;
		}

		if (i > m) {
			for (; j <= r; j++, k++) {
				sorted[k] = list[j];
			}
		} else {
			for (; i <= m; i++, k++) {
				sorted[k] = list[i];
			}
		}

		for (int t = l; t <= r; t++) {
			list[t] = sorted[t];
		}
	}

	static void merge(int l, int r) {
		if (l != r) {
			int m = (l + r) / 2;

			merge(l, m);
			merge(m + 1, r);
			mergesort(l, m, r);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		sorted = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		merge(0, N - 1);
		System.out.println(ans);
	}
}