package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj15666 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Integer> list, ans;
	static Set<ArrayList<Integer>> s = new HashSet<>();
	static int N, M;

	static void dfs(int idx, int cnt) {
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

		for (int i = idx; i < N; i++) {
			int x = list.get(i);

			ans.add(x);
			dfs(i, cnt + 1);
			ans.remove(cnt);
		}
	}

	static void input() throws Exception {
		list = new ArrayList<>();
		ans = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			list.add(x);
		}

		Collections.sort(list);
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0);
		System.out.println(sb.toString());
	}
}