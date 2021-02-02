package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj10866 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Deque<Integer> dq = new ArrayDeque<>();
	static int N;

	static void push_front(int x) {
		dq.addFirst(x);
	}

	static void push_back(int x) {
		dq.addLast(x);
	}

	static void pop_front() {
		if (dq.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(dq.peekFirst() + "\n");
		dq.removeFirst();
	}

	static void pop_back() {
		if (dq.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(dq.peekLast() + "\n");
		dq.removeLast();
	}

	static void size() {
		sb.append(dq.size() + "\n");
	}

	static void empty() {
		if (dq.isEmpty())
			sb.append("1\n");
		else
			sb.append("0\n");
	}

	static void front() {
		if (dq.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(dq.peekFirst() + "\n");
	}

	static void back() {
		if (dq.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(dq.peekLast() + "\n");
	}

	static void input() throws Exception {
		String type;
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken();

			if ("push_front".equals(type)) {
				x = Integer.parseInt(st.nextToken());
				push_front(x);
			} else if ("push_back".equals(type)) {
				x = Integer.parseInt(st.nextToken());
				push_back(x);
			} else if ("pop_front".equals(type))
				pop_front();
			else if ("pop_back".equals(type))
				pop_back();
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