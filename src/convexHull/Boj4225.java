package convexHull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj4225 {
	static class Pair {
		int x;
		int y;
		double a;

		public Pair(int x, int y, double a) {
			this.x = x;
			this.y = y;
			this.a = a;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Pair> list = new ArrayList<>();
	static ArrayList<Pair> hull = new ArrayList<>();
	static double ans;
	static int N;

	static int ccw(Pair a, Pair b, Pair c) {
		int result = a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y);

		return result;
	}

	static void func() {
		list.get(0).a = -4.0;
		Pair xy = new Pair(list.get(0).x, list.get(0).y, list.get(0).a);
		for (int i = 1; i < N; i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;

			if (x == xy.x)
				list.get(i).a = 4.0;
			else {
				double a = Math.atan((double) (y - xy.y) / (double) (x - xy.x));
				list.get(i).a = a;
			}
		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				if (a.a < b.a)
					return -1;
				else if (a.a > b.a)
					return 1;
				else
					return 0;
			}
		});
	}

	static void convexhull() {
		for (int i = 0; i < N; i++) {
			while (true) {
				if (hull.size() < 2) {
					hull.add(new Pair(list.get(i).x, list.get(i).y, list.get(i).a));
					break;
				}

				Pair xy2 = hull.get(hull.size() - 1);
				Pair xy = hull.get(hull.size() - 2);

				if (ccw(xy, xy2, list.get(i)) > 0) {
					hull.add(new Pair(list.get(i).x, list.get(i).y, list.get(i).a));
					break;
				} else {
					hull.remove(hull.size() - 1);
				}
			}
		}
	}

	static double dist(Pair a, Pair b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	static double solvedis(Pair a, Pair b, Pair c) {
		return Math.abs(Math.abs((double) ccw(a, b, c)) / Math.abs(dist(b, c)));
	}

	static void solve() {
		ans = Double.MAX_VALUE;
		int size = hull.size();
		for (int i = 0; i < size; i++) {
			int next = (i + 1) % size;
			double dis = 0.0;
			for (int j = 0; j < size; j++) {
				dis = Math.max(dis, solvedis(hull.get(j), hull.get(i), hull.get(next)));
			}
			ans = Math.min(ans, dis);
		}
	}

	static void input() throws Exception {
		int x, y;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			list.add(new Pair(x, y, 0.0));
		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				if (a.x == b.x)
					return a.y - b.y;
				else
					return a.x - b.x;
			}
		});
	}

	public static void main(String[] args) throws Exception {
		for (int t = 1;; t++) {
			input();
			if (N == 0)
				break;
			func();
			convexhull();
			solve();
			sb.append("Case ").append(t).append(": ").append(String.format("%.2f", Math.ceil(ans * 100) / 100))
					.append("\n");
			list.clear();
			hull.clear();
		}

		System.out.println(sb.toString());
	}
}