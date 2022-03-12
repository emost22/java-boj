package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<int[]> list[] = new ArrayList[20001];
	static int d[] = new int[20001];
	static int N, M, start;

	static class Pair implements Comparable<Pair> {
		int v;
		int dis;

		public Pair(int v, int dis) {
			this.v = v;
			this.dis = dis;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dis - o.dis;
		}
	}

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			if (d[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(d[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void dijkstra(int v) {
		d[v] = 0;
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.add(new Pair(v, 0));

		while (!q.isEmpty()) {
			int now = q.peek().v;
			int dis = q.poll().dis;

			if (d[now] < dis)
				continue;

			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i)[0];
				int nextdis = dis + list[now].get(i)[1];

				if (nextdis < d[next]) {
					d[next] = nextdis;
					q.add(new Pair(next, nextdis));
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
		M = Integer.parseInt(st.nextToken());
		init();

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			list[u].add(new int[] { v, w });
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dijkstra(start);
		print();
	}
}