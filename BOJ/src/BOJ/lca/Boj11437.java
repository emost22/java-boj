package BOJ.lca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11437 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Integer> list[] = new ArrayList[50001];
	static boolean visit[];
	static int parent[][] = new int[50001][17];
	static int depth[] = new int[50001];
	static int N, M;

	static void dfs(int v, int d) {
		visit[v] = true;
		depth[v] = d;

		for (int i = 0; i < list[v].size(); i++) {
			int next = list[v].get(i);

			if (visit[next])
				continue;

			parent[next][0] = v;
			dfs(next, d + 1);
		}
	}

	static void func() {
		dfs(1, 1);
		for (int j = 1; j < 17; j++) {
			for (int i = 1; i <= N; i++) {
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

		for (int i = 16; i >= 0; i--) {
			if (depth[y] - depth[x] >= (1 << i)) {
				y = parent[y][i];
			}
		}

		if (y == x)
			return x;

		for (int i = 16; i >= 0; i--) {
			if (parent[x][i] != parent[y][i]) {
				x = parent[x][i];
				y = parent[y][i];
			}
		}

		return parent[x][0];
	}

	static void solve() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			sb.append(lca(u, v) + "\n");
		}
		
		System.out.print(sb.toString());
	}

	static void input() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		solve();
	}
}