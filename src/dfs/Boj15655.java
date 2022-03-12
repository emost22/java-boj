package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15655 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int list[], ans[];
	static boolean visit[] = new boolean[10001];
	static int N, M;

	static void dfs(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			int x = list[i];

			if (visit[x])
				continue;

			visit[x] = true;
			ans[cnt] = x;
			dfs(i + 1, cnt + 1);
			ans[cnt] = 0;
			visit[x] = false;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0);
		System.out.println(sb.toString());
	}
}