package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj1793 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringBuffer sb = new StringBuffer();
	static BigInteger dp[] = new BigInteger[251];
	static int N;

	static void init() {
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		for (int i = 2; i <= 250; i++) {
			dp[i] = dp[i - 2].multiply(new BigInteger("2")).add(dp[i - 1]);
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		while (true) {
			str = br.readLine();
			if (str == null || str.length() == 0)
				break;
			N = Integer.parseInt(str);
			sb.append(dp[N]).append("\n");
		}

		System.out.print(sb.toString());
	}
}