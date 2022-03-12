package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16637 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char list[] = new char[20];
	static boolean pick[] = new boolean[20];
	static char op[] = new char[10];
	static int num[] = new int[10];
	static long ans = Long.MIN_VALUE;
	static int N;

	static void solve() {
		int i = 0;
		int idx = 0;
		while (i < N) {
			if (pick[i]) {
				if (list[i + 1] == '+')
					num[idx] = list[i] - '0' + list[i + 2] - '0';
				else if (list[i + 1] == '-')
					num[idx] = list[i] - '0' - list[i + 2] + '0';
				else
					num[idx] = (list[i] - '0') * (list[i + 2] - '0');

				if (i + 3 < N)
					op[idx] = list[i + 3];
				i += 4;
			} else {
				num[idx] = list[i] - '0';
				if (i + 1 < N)
					op[idx] = list[i + 1];
				i += 2;
			}
			idx++;
		}

		long sum = num[0];
		for (i = 1; i < idx; i++) {
			if (op[i - 1] == '+')
				sum += num[i];
			else if (op[i - 1] == '-')
				sum -= num[i];
			else
				sum *= num[i];
		}

		ans = Math.max(ans, sum);
	}
 
	static void func(int s) {
		solve();
		for (int i = s; i < N - 1; i += 2) {
			pick[i] = true;
			func(i + 4);
			pick[i] = false;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list = st.nextToken().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0);
		System.out.println(ans);
	}
}