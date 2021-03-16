package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static char list[] = new char[16];
	static int L, C, a, b;

	static void func(int idx, int cnt, String str) {
		if (cnt == L) {
			if (a < 1 || b < 2)
				return;
			sb.append(str).append("\n");
			return;
		}

		if (idx >= C)
			return;

		for (int i = idx; i < C; i++) {
			if (list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o' || list[i] == 'u')
				a++;
			else
				b++;

			func(i + 1, cnt + 1, str + list[i]);

			if (list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o' || list[i] == 'u')
				a--;
			else
				b--;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(list, 0, C);
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0, 0, "");
		System.out.print(sb.toString());
	}
}