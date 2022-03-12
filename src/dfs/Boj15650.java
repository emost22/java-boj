package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15650 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static boolean visit[];
	static int list[];
	static int N, M;

	static void dfs(int num, int cnt) {
		if (cnt == M) {
			for (int x : list) {
				sb.append(x + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = num; i <= N; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			list[cnt] = i;
			dfs(i + 1, cnt + 1);
			list[cnt] = 0;
			visit[i] = false;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[M];
		visit = new boolean[N + 1];
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(1, 0);
		System.out.println(sb.toString());
	}
}