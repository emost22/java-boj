package permutationAndCombination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9742 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str[] = new String[2];
	static StringBuffer sb = new StringBuffer();
	static char list[];
	static int dp[] = new int[11];
	static int N, cnt;

	static void init() {
		dp[1] = 1;
		for (int i = 2; i <= 10; i++) {
			dp[i] = dp[i - 1] * i;
		}
	}

	static void swap(int x, int y) {
		char tmp = list[x];
		list[x] = list[y];
		list[y] = tmp;
	}

	static boolean next_permutation() {
		int i = N - 1;
		while (i >= 0 && list[i - 1] >= list[i])
			i--;
		if (i == 0)
			return false;

		int j = N - 1;
		while (list[i - 1] >= list[j])
			j--;

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	static void func() {
		if (cnt > dp[N]) {
			sb.append("No permutation\n");
			return;
		}

		while (--cnt > 0)
			next_permutation();
		sb.append(String.valueOf(list) + "\n");
	}

	public static void main(String[] args) throws Exception {
		String st = null;
		init();
		while (true) {
			st = br.readLine();
			if (st == null || st.length() == 0)
				break;
			str = st.split(" ");
			list = str[0].toCharArray();
			cnt = Integer.parseInt(str[1]);
			N = list.length;
			sb.append(String.valueOf(list) + " " + cnt + " = ");
			func();
		}

		System.out.print(sb.toString());
	}
}