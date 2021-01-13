package BOJ.dp;

import java.io.*;

public class boj9095 {
	static int dp[] = new int[11];

	static void init() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		init();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
		
		br.close();
	}
}