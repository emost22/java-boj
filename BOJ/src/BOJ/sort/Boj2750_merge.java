package BOJ.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2750_merge {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], sorted[];
	static int N;

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++)
			sb.append(list[i]).append("\n");

		System.out.println(sb.toString());
	}

	static void merge(int l, int m, int r) {
		int i = l;
		int j = m + 1;
		int k = l;

		while (i <= m && j <= r) {
			if (list[i] < list[j])
				sorted[k++] = list[i++];
			else
				sorted[k++] = list[j++];
		}

		if (i > m) {
			for (int t = j; t <= r; t++, k++) {
				sorted[k] = list[t];
			}
		} else {
			for (int t = i; t <= m; t++, k++) {
				sorted[k] = list[t];
			}
		}

		for (int t = l; t <= r; t++)
			list[t] = sorted[t];
	}

	static void mergeSort(int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(l, m);
			mergeSort(m + 1, r);
			merge(l, m, r);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		sorted = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		mergeSort(0, N - 1);
		print();
	}
}