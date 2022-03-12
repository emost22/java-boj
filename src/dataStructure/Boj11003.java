package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], ans[];
	static int N, L;

	static void func() {
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (dq.isEmpty())
				dq.addLast(list[i]);
			else {
				while (true) {
					if (dq.isEmpty())
						break;
					if (dq.peekLast() > list[i])
						dq.removeLast();
					else
						break;
				}

				dq.addLast(list[i]);
			}

			if (L <= i) {
				if (dq.peek() == list[i - L])
					dq.removeFirst();
			}

			ans[i] = dq.peek();
		}
	}

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		ans = new int[N];
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}