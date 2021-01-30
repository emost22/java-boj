package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj15665 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Integer> ans = new ArrayList<>();
	static Set<ArrayList<Integer>> s = new HashSet<>();
	static int list[];
	static int N, M;

	static void func(int cnt) {
		if (cnt == M) {
			if (s.contains(ans))
				return;

			s.add(ans);
			for (int i = 0; i < M; i++) {
				sb.append(ans.get(i) + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			int x = list[i];

			ans.add(x);
			func(cnt + 1);
			ans.remove(cnt);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0);
		System.out.println(sb.toString());
	}
}