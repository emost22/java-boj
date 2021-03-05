package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9658 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean dp[] = new boolean[1001];
	static int N;

	static void func() {
		dp[2] = true;
		dp[4] = true;
		for (int i = 5; i <= N; i++) {
			if (dp[i - 1] && dp[i - 3] && dp[i - 4])
				dp[i] = false;
			else
				dp[i] = true;
		}
	}
	
	static void print() {
		if(dp[N])
			System.out.println("SK");
		else
			System.out.println("CY");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}