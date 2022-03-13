package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj12893 {
	static ArrayList<Integer> list[];
	static int color[];
	static int N, M;

	static int dfs(int v, int d) {
		color[v] = d;

		for (int i = 0; i < list[v].size(); i++) {
			int next = list[v].get(i);

			if (color[next] != -1) {
				if (color[next] == color[v])
					return 0;
				continue;
			}

			if (dfs(next, 1 - d) == 0)
				return 0;
		}

		return 1;
	}

	static void func() {
		Arrays.fill(color, -1);
		for (int i = 1; i <= N; i++) {
			if (color[i] != -1)
				continue;

			if (dfs(i, 0) == 0) {
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		color = new int[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		int u, v;
		while (M-- > 0) {
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
	}
}