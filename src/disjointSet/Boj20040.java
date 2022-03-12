package disjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int parent[] = new int[500001];
	static int N, M, ans;

	static int find(int v) {
		if (parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}

	static boolean union(int x, int y) {
		int a = find(x);
		int b = find(y);

		if (a == b)
			return true;
		parent[b] = a;
		return false;
	}

	static void init() {
		for (int i = 0; i < N; i++)
			parent[i] = i;
	}

	static void input() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			if (union(u, v) && ans == 0)
				ans = i;
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		input();
	}
}