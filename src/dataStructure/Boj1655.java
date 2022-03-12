package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1655 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int list[];
	static int N;

	static void func() {
		PriorityQueue<Integer> maxq = new PriorityQueue<>();
		PriorityQueue<Integer> minq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int x = list[i];

			if (maxq.isEmpty()) {
				maxq.add(-x);
				sb.append(-maxq.peek() + "\n");
				continue;
			}

			if (maxq.size() == minq.size())
				maxq.add(-x);
			else
				minq.add(x);

			if (-maxq.peek() > minq.peek()) {
				int a = -maxq.peek();
				int b = -minq.peek();
				maxq.remove();
				minq.remove();

				maxq.add(b);
				minq.add(a);
			}

			sb.append(-maxq.peek() + "\n");
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.println(sb.toString());
	}
}