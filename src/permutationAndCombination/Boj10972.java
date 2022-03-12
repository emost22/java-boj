package permutationAndCombination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10972 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[];
	static int N;

	static void swap(int x, int y) {
		int tmp = list[x];
		list[x] = list[y];
		list[y] = tmp;
	}

	static boolean next_permutation() {
		int i = N - 1;
		while (i > 0 && list[i - 1] > list[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (list[i - 1] > list[j])
			j--;

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	static void func() {
		if (next_permutation()) {
			StringBuffer sb = new StringBuffer();
			for (int x : list)
				sb.append(x + " ");
			System.out.println(sb.toString());
		} else
			System.out.println(-1);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}