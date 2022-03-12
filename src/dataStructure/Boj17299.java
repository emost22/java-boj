package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17299 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Stack<Integer> s = new Stack<>();
	static int list[], num[], ans[];
	static int N;

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++)
			sb.append(ans[i]).append(" ");
		System.out.println(sb.toString());
	}

	static void func() {
		for (int i = N; i > 0; i--) {
			while (!s.isEmpty() && num[list[i]] >= num[s.peek()])
				s.pop();

			if (s.isEmpty())
				ans[i] = -1;
			else
				ans[i] = s.peek();

			s.push(list[i]);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1];
		num = new int[1000001];
		ans = new int[1000001];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			num[list[i]]++;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}