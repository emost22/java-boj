package segmentTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6549 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int tree[] = new int[400004];
	static long list[] = new long[100001];
	static int N;

	static int init(int node, int s, int e) {
		if (s == e)
			return tree[node] = s;

		int m = (s + e) / 2;
		int l = init(node * 2, s, m);
		int r = init(node * 2 + 1, m + 1, e);
		return tree[node] = list[l] < list[r] ? l : r;
	}

	static int query(int node, int s, int e, int l, int r) {
		if (l > e || s > r)
			return -1;
		if (l <= s && e <= r)
			return tree[node];

		int m = (s + e) / 2;
		int a = query(node * 2, s, m, l, r);
		int b = query(node * 2 + 1, m + 1, e, l, r);

		if (a == -1)
			return b;
		else if (b == -1)
			return a;
		else
			return list[a] < list[b] ? a : b;
	}

	static long func(int l, int r) {
		int idx = query(1, 1, N, l, r);
		long sum = list[idx] * (r - l + 1);

		if (idx > l)
			sum = Math.max(sum, func(l, idx - 1));
		if (idx < r)
			sum = Math.max(sum, func(idx + 1, r));

		return sum;
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		if (N == 0)
			return;

		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		init(1, 1, N);
	}

	public static void main(String[] args) throws Exception {
		while (true) {
			input();
			if (N == 0)
				break;
			sb.append(func(1, N)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}