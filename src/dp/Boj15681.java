package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15681 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> graph[] = new ArrayList[100001];
	static boolean visit[] = new boolean[100001];
	static int subtree[] = new int[100001];
	static int N, root, ques;

	static void solve() throws Exception {
		StringBuffer sb = new StringBuffer();
		int x;
		while (ques-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			sb.append(subtree[x]).append("\n");
		}

		System.out.println(sb.toString());
	}

	static int dfs(int v) {
		visit[v] = true;

		int sum = 0;
		for (int i = 0; i < graph[v].size(); i++) {
			int next = graph[v].get(i);

			if (visit[next])
				continue;

			sum += dfs(next);
		}

		if (sum == 0)
			return subtree[v] = 1;

		return subtree[v] = sum + 1;
	}

	static void input() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		root = Integer.parseInt(st.nextToken());
		ques = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(root);
		solve();
	}
}