package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1927 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static PriorityQueue<Integer> q = new PriorityQueue<>();
	static int N, x;

	static void solve() {
		if (x == 0) {
			if (q.isEmpty()) {
				sb.append("0\n");
				return;
			}

			sb.append(q.peek() + "\n");
			q.remove();
			return;
		}

		q.add(x);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());

			solve();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(sb.toString());
	}
}