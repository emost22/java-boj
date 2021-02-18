package BOJ.segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10211 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int tree[] = new int[4004];
	static int list[] = new int[1001];
	static int N;

	static int init(int node, int s, int e) {
		if (s == e)
			return tree[node] = list[s];

		int m = (s + e) / 2;
		return tree[node] = init(node * 2, s, m) + init(node * 2 + 1, m + 1, e);
	}

	static int query(int node, int s, int e, int l, int r) {
		if (s > r || l > e)
			return 0;
		if (l <= s && e <= r)
			return tree[node];

		int m = (s + e) / 2;
		return query(node * 2, s, m, l, r) + query(node * 2 + 1, m + 1, e, l, r);
	}

	static void func() {
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				ans = Math.max(ans, query(1, 1, N, i, j));
			}
		}
		
		sb.append(ans).append("\n");
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
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			func();
		}
		
		System.out.println(sb.toString());
	}
}