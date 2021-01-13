package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj12101 {
	static int N, K, cnt;
	static int dp[] = new int[11];
	static ArrayList<Integer> list = new ArrayList<>();

	static void init() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
	}

	static void func(int num) {
		if (dp[N] < K) {
			System.out.println(-1);
			return;
		}

		if (num == 0) {
			cnt++;
			if (cnt == K) {
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));
					if (i != list.size() - 1)
						System.out.print("+");
				}
				System.out.println();
			}

			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (num - i >= 0) {
				list.add(i);
				func(num - i);
				list.remove(list.size() - 1);
				if (cnt == K)
					return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		init();
		func(N);
	}
}
