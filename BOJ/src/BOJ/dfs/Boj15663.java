package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj15663 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Integer> list, ans;
	static int N, M;
	static boolean visit[];
	static Set<ArrayList<Integer>> s = new HashSet<>();

	static void dfs(int cnt) {
		if (cnt == M) {
			if (s.contains(ans))
				return;

			s.add(ans);
			for (int i = 0; i < ans.size(); i++) {
				sb.append(ans.get(i) + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;

			int x = list.get(i);

			visit[i] = true;
			ans.add(x);
			dfs(cnt + 1);
			ans.remove(cnt);
			visit[i] = false;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		ans = new ArrayList<>();
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0);
		System.out.println(sb.toString());
	}
}