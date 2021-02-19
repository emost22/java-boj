package BOJ.segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2104 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long tree[][] = new long[400004][2];
	static int list[] = new int[100001];
	static int N;

	static long[] init(int node, int s, int e) {
		if (s == e) {
			tree[node][0] = list[s];
			tree[node][1] = s;
			return tree[node];
		}

		int m = (s + e) / 2;
		long l[] = init(node * 2, s, m);
		long r[] = init(node * 2 + 1, m + 1, e);
		tree[node][0] = l[0] + r[0];
		if (list[(int) l[1]] < list[(int) r[1]])
			tree[node][1] = l[1];
		else
			tree[node][1] = r[1];
		return tree[node];
	}

	static long query(int node, int s, int e, int l, int r) {
		if (s > r || l > e)
			return 0;
		if (l <= s && e <= r)
			return tree[node][0];

		int m = (s + e) / 2;
		return query(node * 2, s, m, l, r) + query(node * 2 + 1, m + 1, e, l, r);
	}

	static long findmin(int node, int s, int e, int l, int r) {
		if (s > r || l > e)
			return -1;
		if (l <= s && e <= r)
			return tree[node][1];

		int m = (s + e) / 2;
		long a = findmin(node * 2, s, m, l, r);
		long b = findmin(node * 2 + 1, m + 1, e, l, r);
		if (a == -1)
			return b;
		else if (b == -1)
			return a;
		else {
			if (list[(int) a] > list[(int) b])
				return b;
			else
				return a;
		}
	}

	static long func(int s, int e) {
		int idx = (int) findmin(1, 1, N, s, e);
		long sum = query(1, 1, N, s, e) * list[idx];

		if (s < idx)
			sum = Math.max(sum, func(s, idx - 1));
		if (idx < e)
			sum = Math.max(sum, func(idx + 1, e));

		return sum;
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 1, N);
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(func(1, N));
	}
}