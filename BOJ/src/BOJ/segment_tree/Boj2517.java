package BOJ.segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj2517 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][], tree[], rank[];
	static int N;

	static int query(int node, int s, int e, int l, int r) {
		if (l <= s && e <= r)
			return tree[node];
		if (s > r || e < l)
			return 0;

		int m = (s + e) / 2;
		return query(node * 2, s, m, l, r) + query(node * 2 + 1, m + 1, e, l, r);
	}

	static void update(int node, int s, int e, int idx) {
		if (idx < s || idx > e)
			return;

		tree[node]++;
		int m = (s + e) / 2;
		if (s != e) {
			update(node * 2, s, m, idx);
			update(node * 2 + 1, m + 1, e, idx);
		}
	}

	static void func() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			int ans = query(1, 1, N, 1, list[i][1]);

			rank[list[i][1]] = list[i][1] - ans;
			update(1, 1, N, list[i][1]);
		}

		for (int i = 1; i <= N; i++) {
			sb.append(rank[i]+"\n");
		}
		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1][2];
		rank = new int[N + 1];
		tree = new int[N * 4];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = i;
		}

		Arrays.sort(list, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] > b[0])
					return 1;
				else
					return -1;
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}