package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int parent[];
	static int N, M;

	static int union_find(int v) {
		if (parent[v] == v)
			return v;
		return parent[v] = union_find(parent[v]);
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
		parent = new int[N + 1];
		init();
	}

	public static void main(String[] args) throws Exception {
		int type, u, v;
		input();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			type = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			int a = union_find(u);
			int b = union_find(v);
			if (type == 0) {
				parent[b] = a;
			} else {
				if (a == b)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}

		System.out.println(sb.toString());
	}
}