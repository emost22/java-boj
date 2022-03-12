package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj2331 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Set<Integer> s = new HashSet<>();
	static int N, M, cyclestart, ans;

	static void func(int num, int cnt) {
		s.add(num);

		int next = 0;
		int n = num;
		while (true) {
			next += Math.pow(n % 10, M);
			n /= 10;
			if (n == 0)
				break;
		}

		if (s.contains(next)) {
			if (next == num)
				ans = cnt - 1;
			cyclestart = next;
			return;
		}

		func(next, cnt + 1);
		if (cyclestart == num)
			ans = cnt - 1;
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		func(N, 1);
		System.out.println(ans);
	}
}