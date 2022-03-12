package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2239 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char div[][] = { { 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c' },
			{ 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c' }, { 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c' },
			{ 'd', 'd', 'd', 'e', 'e', 'e', 'f', 'f', 'f' }, { 'd', 'd', 'd', 'e', 'e', 'e', 'f', 'f', 'f' },
			{ 'd', 'd', 'd', 'e', 'e', 'e', 'f', 'f', 'f' }, { 'g', 'g', 'g', 'h', 'h', 'h', 'i', 'i', 'i' },
			{ 'g', 'g', 'g', 'h', 'h', 'h', 'i', 'i', 'i' }, { 'g', 'g', 'g', 'h', 'h', 'h', 'i', 'i', 'i' } };
	static boolean cols[][] = new boolean[9][10];
	static boolean rows[][] = new boolean[9][10];
	static boolean divchk[][] = new boolean[9][10];
	static char ch[][] = new char[9][9];
	static boolean endchk;

	static void dfs(int x, int y) {
		if (x == 9) {
			endchk = true;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(ch[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
			return;
		}
		int nx = x;
		int ny = y + 1;

		if (ny == 9) {
			ny = 0;
			nx++;
		}

		if (ch[x][y] != '0') {
			dfs(nx, ny);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (divchk[div[x][y] - 'a'][i] || cols[x][i] || rows[y][i])
				continue;

			divchk[div[x][y] - 'a'][i] = true;
			cols[x][i] = true;
			rows[y][i] = true;
			ch[x][y] += i;
			dfs(nx, ny);
			ch[x][y] -= i;
			divchk[div[x][y] - 'a'][i] = false;
			cols[x][i] = false;
			rows[y][i] = false;
			if (endchk)
				return;
		}
	}

	static void input() throws Exception {
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			ch[i] = st.nextToken().toCharArray();
			for (int j = 0; j < 9; j++) {
				divchk[div[i][j] - 'a'][ch[i][j] - '0'] = true;
				cols[i][ch[i][j] - '0'] = true;
				rows[j][ch[i][j] - '0'] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0);
	}
}