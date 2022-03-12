package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13116 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int depth[] = new int[1024];
	static int parent[][] = new int[1024][11];

	static void dfs(int v, int d) {
		depth[v] = d;
		parent[v][0] = v / 2;

		int next = v * 2;

		if (next >= 1024)
			return;

		dfs(next, d + 1);
		dfs(next + 1, d + 1);
	}

	static void init() {
		dfs(1, 1);
		for (int j = 1; j < 11; j++) {
			for (int i = 1; i <= 1023; i++) {
				parent[i][j] = parent[parent[i][j - 1]][j - 1];
			}
		}
	}

	static int lca(int x, int y) {
		if (depth[x] > depth[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		for (int i = 10; i >= 0; i--) {
			if (depth[y] - depth[x] >= (1 << i)) {
				y = parent[y][i];
			}
		}

		if (x == y)
			return x;

		for (int i = 10; i >= 0; i--) {
			if (parent[x][i] != parent[y][i]) {
				x = parent[x][i];
				y = parent[y][i];
			}
		}
		
		return parent[x][0];
	}

	static void input() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		sb.append(lca(u, v) * 10 + "\n");
	}

	public static void main(String[] args) throws Exception {
		init();
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
		}
		
		System.out.println(sb.toString());
	}
}