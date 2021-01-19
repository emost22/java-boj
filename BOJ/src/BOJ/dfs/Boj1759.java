package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L, C, a, b;
	static char ch[];
	static boolean visit[];
	static ArrayList<char[]> list = new ArrayList<>();

	static void dfs(int idx, int cnt) {
		if (cnt == L) {
			if (a < 1 || b < 2)
				return;
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)[0]);
			}
			System.out.println();
			return;
		}
		if (idx >= C)
			return;

		for (int i = idx; i < C; i++) {
			if (visit[i])
				continue;

			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'i')
				a++;
			else
				b++;

			visit[i] = true;
			list.add(new char[] { ch[i] });
			dfs(i + 1, cnt + 1);
			list.remove(list.size() - 1);
			visit[i] = false;

			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'i')
				a--;
			else
				b--;

		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		ch = new char[C];
		visit = new boolean[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(ch);
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0);
	}
}