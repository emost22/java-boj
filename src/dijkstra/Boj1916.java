package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1916 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<int[]> list[] = new ArrayList[1001];
	static int d[] = new int[1001];
	static int N, M, start, des;

	static void dijkstra(int s) {
		d[s] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		q.add(new int[] { s, 0 });

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
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			d[i] = Integer.MAX_VALUE;
		}
	}

	static void input() throws Exception {
		int u, v, w;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		init();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			list[u].add(new int[] { v, w });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		des = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		dijkstra(start);
		System.out.println(d[des]);
	}
}