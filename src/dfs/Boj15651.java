package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15651 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int list[];
	static int N, M;

	static void dfs(int cnt) {
		if (cnt == M) {
			for (int x : list) {
				sb.append(x + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			list[cnt] = i;
			dfs(cnt + 1);
			list[cnt] = 0;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[M];
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0);
		System.out.println(sb.toString());
	}
}