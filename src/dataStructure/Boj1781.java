package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1781 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	});
	static int list[][] = new int[200001][2];
	static int N, qsize;

	static void func() {
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int x = list[i][0];
			int y = list[i][1];
			q.add(y);
			qsize++;

			if (qsize > x) {
				qsize--;
				q.remove();
			}
		}

		while (!q.isEmpty()) {
			ans += q.poll();
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list, 0, N, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}