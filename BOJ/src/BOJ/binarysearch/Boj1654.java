package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1654 {
	static int list[] = new int[10001];
	static int K, N;
	static long ans;

	static long binarysearch(long l, long r) {
		if (l > r)
			return ans;
		long m = (l + r) / 2;

		int sum = 0;
		for (int i = 1; i <= K; i++) {
			sum += list[i] / m;
		}

		if (sum >= N) {
			ans = Math.max(ans, m);
			return binarysearch(m + 1, r);
		} else {
			return binarysearch(l, m - 1);
		}
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(binarysearch(1, 2147483647));
	}
}
