package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj13549 {
	static class Pair {
		int cnt;
		int x;
	}

	static int N, K, ans;
	static boolean visit[] = new boolean[100001];

	static void bfs() {
		Deque<Pair> q = new LinkedList<Pair>();
		Pair p = new Pair();
		Pair np = null;
		p.x = N;
		p.cnt = 0;
		q.add(p);
		visit[N] = true;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int cnt = q.peek().cnt;
			q.remove();

			if (x == K) {
				ans = cnt;
				return;
			}

			if (x * 2 <= 100000 && !visit[x * 2]) {
				np = new Pair();
				np.x = x * 2;
				np.cnt = cnt;

				q.addFirst(np);
				visit[x * 2] = true;
			}

			if (x - 1 >= 0 && !visit[x - 1]) {
				np = new Pair();
				np.x = x - 1;
				np.cnt = cnt + 1;

				q.add(np);
				visit[x - 1] = true;
			}
			if (x + 1 <= 100000 && !visit[x + 1]) {
				np = new Pair();
				np.x = x + 1;
				np.cnt = cnt + 1;

				q.add(np);
				visit[x + 1] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(ans);
	}

}
