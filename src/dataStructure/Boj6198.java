package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj6198 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Stack<int[]> s = new Stack<>();
	static int list[];
	static int N;
	static long ans;

	static void func() {
		for (int i = 0; i < N; i++) {
			while (!s.isEmpty() && s.peek()[0] <= list[i]) {
				ans += (i - (s.peek()[1] + 1));
				s.pop();
			}

			s.push(new int[] { list[i], i });
		}

		int pre = N - 1;
		while (!s.isEmpty()) {
			ans += (pre - s.peek()[1]);
			s.pop();
		}
		
		System.out.println(ans);
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
	}
}