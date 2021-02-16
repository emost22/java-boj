package 순열조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj6443 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static char list[];
	static int N;

	static void swap(int x, int y) {
		char tmp = list[x];
		list[x] = list[y];
		list[y] = tmp;
	}

	static boolean next_permutation() {
		int i = N - 1;
		while (i > 0 && list[i - 1] >= list[i])
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
		do {
			sb.append(String.valueOf(list) + "\n");
		} while (next_permutation());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		list = st.nextToken().toCharArray();
		N = list.length;
		Arrays.sort(list);
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			func();
		}
		System.out.println(sb.toString());
	}
}