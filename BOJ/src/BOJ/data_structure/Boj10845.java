package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10845 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Queue<Integer> q = new LinkedList<>();
	static int N, last;

	static void push(int x) {
		q.add(x);
	}

	static void pop() {
		if (q.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(q.peek() + "\n");
		q.remove();
	}

	static void size() {
		sb.append(q.size() + "\n");
	}

	static void empty() {
		if (q.isEmpty())
			sb.append("1\n");
		else
			sb.append("0\n");
	}

	static void front() {
		if (q.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(q.peek() + "\n");
	}

	static void back() {
		if (q.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(last + "\n");
	}

	static void input() throws Exception {
		String type;
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken();

			if ("push".equals(type)) {
				x = Integer.parseInt(st.nextToken());
				push(x);
				last = x;
			} else if ("pop".equals(type))
				pop();
			else if ("size".equals(type))
				size();
			else if ("empty".equals(type))
				empty();
			else if ("front".equals(type))
				front();
			else
				back();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(sb.toString());
	}
}