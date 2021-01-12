package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {
	static class Pair {
		int x;
		int cnt;
	}
	static int N, K, ans;
	static boolean visit[] = new boolean[100001];

	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		Pair p = new Pair();
		Pair np = null;
		p.x = N;
		p.cnt = 0;

		q.add(p);
		visit[N] = true;
		while (!q.isEmpty()) {
			p = q.peek();
			q.remove();

			if (p.x == K) {
				ans = p.cnt;
				return;
			}
			int nx1 = p.x - 1;
			int nx2 = p.x + 1;
			int nx3 = p.x * 2;

			if (nx1 >= 0 && !visit[nx1]) {
				np = new Pair();
				np.x = nx1;
				np.cnt = p.cnt + 1;
				q.add(np);
				visit[nx1] = true;
			}
			if (nx2 <= 100000 && !visit[nx2]) {
				np = new Pair();
				np.x = nx2;
				np.cnt = p.cnt + 1;
				q.add(np);
				visit[nx2] = true;
			}
			if (nx3 <= 100000 && !visit[nx3]) {
				np = new Pair();
				np.x = nx3;
				np.cnt = p.cnt + 1;
				q.add(np);
				visit[nx3] = true;
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