package disjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18116 {
	static final int MAX = 1000001;
	static int parent[], cnt[];
	static int N;

	static int find(int v) {
		if (parent[v] == v)
			return v;
		else
			return parent[v] = find(parent[v]);
	}

	static void union(int u, int v) {
		u = find(u);
		v = find(v);

		if (parent[u] == parent[v])
			return;

		cnt[parent[u]] += cnt[v];
		parent[v] = u;
	}

	static void init() {
		parent = new int[MAX];
		cnt = new int[MAX];

		for (int i = 1; i < MAX; i++) {
			parent[i] = i;
			cnt[i] = 1;
		}
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		char type;
		int u, v;

		N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken().charAt(0);

			if (type == 'I') {
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				union(u, v);
			} else {
				u = Integer.parseInt(st.nextToken());
				sb.append(cnt[find(u)] + "\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		init();
		input();
	}
}