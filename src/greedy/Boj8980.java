package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj8980 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<int[]> list = new ArrayList<>();
	static int to[];
	static int N, C, M, ans;

	static void func() {
		for (int i = 0; i < M; i++) {
			int u = list.get(i)[0];
			int v = list.get(i)[1];
			int c = list.get(i)[2];

			int maxC = Integer.MAX_VALUE;
			for (int j = u; j < v; j++)
				maxC = Math.min(maxC, to[j]);

			if (maxC >= c) {
				for (int j = u; j < v; j++)
					to[j] -= c;
				ans += c;
			} else {
				for (int j = u; j < v; j++)
					to[j] -= maxC;
				ans += maxC;
			}
		}
		
		System.out.println(ans);
	}

	static void input() throws Exception {
		int u, v, c;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		to = new int[N + 1];
		Arrays.fill(to, C);

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list.add(new int[] { u, v, c });
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1] == b[1])
					return a[0] - b[0];
				else
					return a[1] - b[1];
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}