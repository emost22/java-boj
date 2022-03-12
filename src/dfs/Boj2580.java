package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2580 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char div[][] = { { 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c' },
			{ 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c' }, { 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c' },
			{ 'd', 'd', 'd', 'e', 'e', 'e', 'f', 'f', 'f' }, { 'd', 'd', 'd', 'e', 'e', 'e', 'f', 'f', 'f' },
			{ 'd', 'd', 'd', 'e', 'e', 'e', 'f', 'f', 'f' }, { 'g', 'g', 'g', 'h', 'h', 'h', 'i', 'i', 'i' },
			{ 'g', 'g', 'g', 'h', 'h', 'h', 'i', 'i', 'i' }, { 'g', 'g', 'g', 'h', 'h', 'h', 'i', 'i', 'i' } };
	static boolean cols[][] = new boolean[9][10];
	static boolean rows[][] = new boolean[9][10];
	static boolean visit[][] = new boolean[9][10];
	static int list[][] = new int[9][9];
	static ArrayList<int[]> e = new ArrayList<>();
	static boolean chk;

	static void dfs(int idx) {
		if (idx == e.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(list[i][j] + " ");
				}
				System.out.println();
			}
			chk = true;
			return;
		}

		int x = e.get(idx)[0];
		int y = e.get(idx)[1];
		for (int i = 1; i <= 9; i++) {
			if (rows[x][i] || cols[y][i] || visit[div[x][y] - 'a'][i])
				continue;

			rows[x][i] = true;
			cols[y][i] = true;
			visit[div[x][y] - 'a'][i] = true;
			list[x][y] = i;
			dfs(idx + 1);
			if (chk)
				return;
			list[x][y] = 0;
			rows[x][i] = false;
			cols[y][i] = false;
			visit[div[x][y] - 'a'][i] = false;
		}
	}

	static void input() throws Exception {
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if (list[i][j] == 0) {
					e.add(new int[] { i, j });
				} else {
					cols[j][list[i][j]] = true;
					rows[i][list[i][j]] = true;
					visit[div[i][j] - 'a'][list[i][j]] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0);
	}
}