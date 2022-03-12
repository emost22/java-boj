package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9184 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int dp[][][] = new int[51][51][51];
	static int a, b, c;

	static void init() {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				dp[0][i][j] = 1;
				dp[i][0][j] = 1;
				dp[i][j][0] = 1;
			}
		}

		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				for (int k = 1; k <= 20; k++) {
					if (i < j && j < k)
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					else
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
								- dp[i - 1][j - 1][k - 1];
				}
			}
		}
	}

	static void func() {
		sb.append("w(" + a + ", " + b + ", " + c + ") = ");
		if (a <= 0 || b <= 0 || c <= 0)
			sb.append("1\n");
		else if (a > 20 || b > 20 || c > 20)
			sb.append(dp[20][20][20] + "\n");
		else
			sb.append(dp[a][b][c] + "\n");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		init();
		while (true) {
			input();
			if (a == -1 && b == -1 && c == -1)
				break;
			func();
		}
		
		System.out.println(sb.toString());
	}
}