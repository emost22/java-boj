package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> list[];
	static boolean visit[];
	static int N, M, ans;

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		while (!q.isEmpty()) {
			int v = q.peek();

			q.remove();

			for (int i = 0; i < list[v].size(); i++) {
				int next = list[v].get(i);

				if (visit[next])
					continue;

				q.add(next);
				visit[next] = true;
				ans++;
			}
		}
	}

	static void input() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

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
		bfs();
		System.out.println(ans);
	}
}