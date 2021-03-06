package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1535 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[][] = new int[21][100];
	static int hpminus[] = new int[21];
	static int happyup[] = new int[21];
	static int N;

	static void func() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 100; j++) {
				if (hpminus[i] > j) {
					dp[i][j] = dp[i - 1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - hpminus[i]] + happyup[i]);
			}
		}
		
		System.out.println(dp[N][99]);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			hpminus[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			happyup[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}