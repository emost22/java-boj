package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Queue<int[]> q = new LinkedList<>();
	static int num[] = new int[10];
	static int N, M, maxp;

	static void func() {
		while (true) {
			int x = q.peek()[0];
			int idx = q.peek()[1];

			q.remove();
			if (x != maxp)
				q.add(new int[] { x, idx });
			else {
				if (idx == M) {
					sb.append(N - q.size() + "\n");
					return;
				}
				num[x]--;
				if (num[x] == 0) {
					for (int i = x; i >= 1; i--) {
						if (num[i] > 0) {
							maxp = i;
							break;
						}
					}
				}
			}
		}
	}

	static void input() throws Exception {
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(st.nextToken());
			q.add(new int[] { x, i });
			num[x]++;
			maxp = Math.max(maxp, x);
		}
	}

	static void clear() {
		maxp = 0;
		for (int i = 1; i <= 9; i++)
			num[i] = 0;
		while (!q.isEmpty())
			q.remove();
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			func();
			clear();
		}
		System.out.println(sb.toString());
	}
}