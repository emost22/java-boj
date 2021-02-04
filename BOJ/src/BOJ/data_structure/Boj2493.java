package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Stack<Integer> s = new Stack<>();
	static int list[], ans[];
	static int N;

	static void print() {
		for (int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}

		System.out.println(sb.toString());
	}

	static void func() {
		for (int i = N - 1; i >= 0; i--) {
			while (!s.isEmpty() && list[s.peek()] < list[i]) {
				ans[s.peek()] = i + 1;
				s.pop();
			}

			s.push(i);
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		ans = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		func();
		print();
	}
}