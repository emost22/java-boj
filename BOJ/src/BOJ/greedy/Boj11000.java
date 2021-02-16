package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj11000 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][];
	static int N;

	static void func() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(list[0][1]);
		for (int i = 1; i < N; i++) {
			int x = q.peek();

			if (x <= list[i][0])
				q.remove();
			q.add(list[i][1]);
		}

		System.out.println(q.size());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return a[1] - b[1];
				else
					return a[0] - b[0];
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}