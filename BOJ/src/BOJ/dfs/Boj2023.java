package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2023 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int N;

	static boolean primeCheck(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0)
				return false;
		}

		return true;
	}

	static void dfs(int cnt, int x) {
		if (cnt == N) {
			sb.append(x).append("\n");
			return;
		}

		for (int i = 1; i <= 9; i += 2) {
			int next = x * 10 + i;
			if (!primeCheck(next))
				continue;

			dfs(cnt + 1, next);
		}
	}

	static void func() {
		dfs(1, 2);
		dfs(1, 3);
		dfs(1, 5);
		dfs(1, 7);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.print(sb.toString());
	}
}