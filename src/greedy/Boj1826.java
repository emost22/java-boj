package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1826 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[][];
	static int N, des, now, ans;

	static void func() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int idx = 0;
		while (idx < N) {
			if (now >= list[idx][0])
				q.add(-list[idx][1]);
			else {
				if (q.isEmpty())
					break;

				now -= q.poll();
				ans++;
				idx--;
			}
			idx++;
		}

		while (!q.isEmpty()) {
			if (now >= des)
				break;
			now -= q.poll();
			ans++;
		}

		if (now >= des)
			System.out.println(ans);
		else
			System.out.println(-1);
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
		st = new StringTokenizer(br.readLine());
		des = Integer.parseInt(st.nextToken());
		now = Integer.parseInt(st.nextToken());

		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}