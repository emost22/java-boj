package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int parent[] = new int[1000001];
	static int N, M;

	static int find(int v) {
		if (parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}

	static void union(int u, int v) {
		int a = find(u);
		int b = find(v);

		if (parent[a] != parent[b])
			parent[b] = parent[a];
	}

	static void func() throws Exception {
		StringBuffer sb = new StringBuffer();
		int type, u, v;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			if (type == 0)
				union(Math.min(u, v), Math.max(u, v));
			else {
				if (find(u) == find(v))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		
		System.out.print(sb.toString());
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		init();
		func();
	}
}