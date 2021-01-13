package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj12851 {
	static class Pair {
		int x;
		int cnt;
	}

	static int N, K, ans, method;
	static boolean visit[] = new boolean[100001];

	static void bfs() {
		Queue<Pair> q = new LinkedList<>();

		Pair p = new Pair();
		Pair np = null;
		p.x = N;
		p.cnt = 0;
		q.add(p);
		ans = 1000000000;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int cnt = q.peek().cnt;
			q.remove();

			visit[x] = true;
			if (x == K) {
				if (ans > cnt) {
					ans = cnt;
					method = 1;
				} else if (ans == cnt)
					method++;
			}

			if (ans != -1 && ans < cnt)
				return;

			if (x - 1 >= 0 && !visit[x - 1]) {
				np = new Pair();
				np.x = x - 1;
				np.cnt = cnt + 1;

				q.add(np);
			}
			if (x + 1 <= 100000 && !visit[x + 1]) {
				np = new Pair();
				np.x = x + 1;
				np.cnt = cnt + 1;

				q.add(np);
			}
			if (x * 2 <= 100000 && !visit[x * 2]) {
				np = new Pair();
				np.x = x * 2;
				np.cnt = cnt + 1;

				q.add(np);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		if (ans == -1)
			ans = 0;
		System.out.println(ans);
		System.out.println(method);
	}
}
