package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Stack<Integer> s = new Stack<>();
	static int list[];
	static int N;

	static void func() {
		for (int i = 0; i < N; i++) {
			while (!s.isEmpty() && list[s.peek()] < list[i])
				s.pop();

			if (s.isEmpty()) {
				s.push(i);
				sb.append("0 ");
			} else {
				sb.append(s.peek() + 1 + " ");
				s.push(i);
			}
		}

		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}