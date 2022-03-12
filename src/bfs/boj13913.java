package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj13913 {
	static int N, K, ans;
	static int parent[] = new int[100001];
	static boolean visit[] = new boolean[100001];

	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { N, 0 });
		visit[N] = true;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int cnt = q.peek()[1];
			q.remove();

			if (x == K) {
				ans = cnt;
				return;
			}

			if (x - 1 >= 0 && !visit[x - 1]) {
				q.add(new int[] { x - 1, cnt + 1 });
				visit[x - 1] = true;
				parent[x - 1] = x;
			}
			if (x + 1 <= 100000 && !visit[x + 1]) {
				q.add(new int[] { x + 1, cnt + 1 });
				visit[x + 1] = true;
				parent[x + 1] = x;
			}
			if (x * 2 <= 100000 && !visit[x * 2]) {
				q.add(new int[] { x * 2, cnt + 1 });
				visit[x * 2] = true;
				parent[x * 2] = x;
			}
		}
	}

	static void print() {
		Stack<Integer> s = new Stack<>();
		System.out.println(ans);
		for (int i = K;; i = parent[i]) {
			s.push(i);
			if (i == N)
				break;
		}
		while (!s.isEmpty()) {
			System.out.print(s.peek() + " ");
			s.pop();
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		print();
	}
}
