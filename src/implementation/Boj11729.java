package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11729 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int N;

	static void func(int n, int a, int b, int c) {
		if (n < 1)
			return;
		func(n - 1, a, c, b);
		sb.append(a + " " + c + "\n");
		func(n - 1, b, a, c);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		sb.append((2 << (N - 1)) - 1 + "\n");
	}

	public static void main(String[] args) throws Exception {
		input();
		func(N, 1, 2, 3);
		System.out.println(sb.toString());
	}
}