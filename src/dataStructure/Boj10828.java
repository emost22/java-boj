package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Stack<Integer> s = new Stack<>();
	static int N;

	static void push(int x) {
		s.push(x);
	}

	static void pop() {
		if (s.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(s.peek() + "\n");
		s.pop();
	}

	static void size() {
		sb.append(s.size() + "\n");
	}

	static void empty() {
		if (s.isEmpty())
			sb.append("1\n");
		else
			sb.append("0\n");
	}

	static void top() {
		if (s.isEmpty()) {
			sb.append("-1\n");
			return;
		}

		sb.append(s.peek() + "\n");
	}

	public static void main(String[] args) throws Exception {
		String type;
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken();

			if ("push".equals(type)) {
				x = Integer.parseInt(st.nextToken());
				push(x);
			} else if ("pop".equals(type))
				pop();
			else if ("size".equals(type))
				size();
			else if ("empty".equals(type))
				empty();
			else
				top();
		}
		
		System.out.println(sb.toString());
	}
}