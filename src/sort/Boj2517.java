package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2517 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][], rank[], sorted[][];

	static int N;

	static void mergesort(int l, int m, int r) {
		int i = l;
		int k = l;
		int j = m + 1;

		while (i <= m && j <= r) {
			if (list[i][0] > list[j][0]) {
				sorted[k][0] = list[i][0];
				sorted[k][1] = list[i][1];

				i++;
				k++;
			} else {
				sorted[k][0] = list[j][0];
				sorted[k][1] = list[j][1];

				rank[list[j][1]] -= (j - k);

				j++;
				k++;
			}
		}

		if (i > m) {
			for (; j <= r; j++, k++) {
				sorted[k][0] = list[j][0];
				sorted[k][1] = list[j][1];
			}
		} else if (j > r) {
			for (; i <= m; i++, k++) {
				sorted[k][0] = list[i][0];
				sorted[k][1] = list[i][1];
			}
		}

		for (int t = l; t <= r; t++) {
			list[t][0] = sorted[t][0];
			list[t][1] = sorted[t][1];
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

	static void print() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			sb.append(rank[i]+"\n");
		}
		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1][2];
		sorted = new int[N + 1][2];
		rank = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = i;
			rank[i] = i;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		merge(1, N);
		print();
	}
}