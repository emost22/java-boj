package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2839 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;

	static void func() {
		int ans = 0;
		while (true) {
			if (N % 5 == 0) {
				ans += (N / 5);
				N = 0;
			} else {
				ans++;
				N -= 3;
			}

			if (N == 0)
				break;
			
			if (N < 5 && N % 3 != 0) {
				ans = -1;
				break;
			}
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}