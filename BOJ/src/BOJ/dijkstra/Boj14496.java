package BOJ.dijkstra;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Boj14496 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<int[]> list[] = new ArrayList[1001];
	static final int INF = 1000000000;
	static int d[] = new int[1001];
	static int N, M, start, des;

	static void dijkstra() {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		q.add(new int[] { start, 0 });
		d[start] = 0;
		while (!q.isEmpty()) {
			int now = q.peek()[0];
			int dis = q.poll()[1];

			if (d[now] < dis)
				continue;

			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i)[0];
				int nextdis = dis + list[now].get(i)[1];

				if (d[next] > nextdis) {
					d[next] = nextdis;
					q.add(new int[] { next, nextdis });
				}
			}
		}

		if (d[des] == INF)
			System.out.println(-1);
		else
			System.out.println(d[des]);
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			d[i] = INF;
		}
	}

	static void input() throws Exception {
		int u, v;
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		des = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			list[u].add(new int[] { v, 1 });
			list[v].add(new int[] { u, 1 });
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
	}
}