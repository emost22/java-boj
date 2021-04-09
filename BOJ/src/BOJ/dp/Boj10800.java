package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj10800 {
	static class Pair {
		int idx;
		int color;
		int size;

		public Pair(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Pair> list;
	static int sum[] = new int[200001];
	static int colorsum[] = new int[200001];
	static int sizesum[] = new int[2001];
	static int ans[] = new int[200001];
	static int N;

	static void func() {
		int pre[] = new int[3];
		for (int i = 1; i <= N; i++) {
			int idx = list.get(i - 1).idx;
			int color = list.get(i - 1).color;
			int size = list.get(i - 1).size;

			sum[i] = sum[i - 1] + size;
			colorsum[color] += size;
			sizesum[size] += size;

			if (color == pre[1] && size == pre[2])
				ans[idx] = ans[pre[0]];
			else
				ans[idx] = sum[i] - colorsum[color] - sizesum[size] + size;

			pre[0] = idx;
			pre[1] = color;
			pre[2] = size;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		int x, y;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			list.add(new Pair(i, x, y));
		}

		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.size == o2.size)
					return o1.color - o2.color;
				else
					return o1.size - o2.size;
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}