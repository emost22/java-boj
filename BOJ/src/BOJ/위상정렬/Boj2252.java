package BOJ.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Integer> list[] = new ArrayList[32001];
	static ArrayList<Integer> ans = new ArrayList<>();
	static int conn[] = new int[32001];
	static int N, M;

	static void print() {
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i) + " ");
		}
		System.out.println(sb.toString());
	}

	static void func() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (conn[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int x = q.poll();

			ans.add(x);
			for (int i = 0; i < list[x].size(); i++) {
				int y = list[x].get(i);

				conn[y]--;

				if (conn[y] == 0)
					q.add(y);
			}
		}
	}

	static void input() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			conn[v]++;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}