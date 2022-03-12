package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2346 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Deque<int[]> dq = new ArrayDeque<>();
	static int N;

	static void func() {
		for (int i = 0; i < N; i++) {
			int next = dq.peekFirst()[0];
			sb.append(dq.peekFirst()[1] + " ");
			dq.removeFirst();

			if (dq.isEmpty())
				break;
			
			if (next > 0) {
				next--;
				while (next-- > 0) {
					dq.addLast(dq.peekFirst());
					dq.removeFirst();
				}
			} else {
				while (next++ < 0) {
					dq.addFirst(dq.peekLast());
					dq.removeLast();
				}
			}
		}

		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dq.addLast(new int[] { Integer.parseInt(st.nextToken()), i });
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}