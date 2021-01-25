package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15649 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] visit = new boolean[9];
	static int N, M;

	static void dfs(int cnt) {
		if (cnt == M) {
			for (Integer x : list) {
				sb.append(x + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			list.add(i);
			dfs(cnt + 1);
			list.remove(list.size() - 1);
			visit[i] = false;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0);
		System.out.println(sb.toString());
	}
}