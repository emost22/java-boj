package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9202 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int direct[][] = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	static int score[] = { 0, 0, 0, 1, 1, 2, 3, 5, 11 };
	static String dict[];
	static char list[][];
	static boolean visit[][], chk;
	static String maxlength = "";
	static int N, M, maxscore, ans;

	static void dfs(int k, int idx, int x, int y) {
		if (idx + 1 == dict[k].length()) {
			if (maxlength == "")
				maxlength = dict[k];
			else {
				if (maxlength.length() < dict[k].length())
					maxlength = dict[k];
				else if (maxlength.length() == dict[k].length()) {
					if (maxlength.compareTo(dict[k]) > 0)
						maxlength = dict[k];
				}
			}

			maxscore += score[idx + 1];
			chk = true;
			return;
		}

		visit[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nx = x + direct[i][0];
			int ny = y + direct[i][1];

			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
				continue;
			if (visit[nx][ny] || list[nx][ny] != dict[k].charAt(idx + 1))
				continue;

			dfs(k, idx + 1, nx, ny);
			if (chk)
				return;

			visit[nx][ny] = false;
		}
	}

	static void func() {
		for (int k = 0; k < N; k++) {
			chk = false;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (list[i][j] == dict[k].charAt(0)) {
						visit = new boolean[4][4];
						dfs(k, 0, i, j);
						if (chk) {
							ans++;
							break;
						}
					}
				}

				if (chk)
					break;
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dict = new String[N];
		list = new char[4][4];

		for (int i = 0; i < N; i++) {
			dict[i] = br.readLine();
		}
		br.readLine();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				list[j] = st.nextToken().toCharArray();
			}

			func();
			sb.append(maxscore + " " + maxlength + " " + ans + "\n");
			maxscore = 0;
			maxlength = "";
			ans = 0;

			if (i == M - 1)
				break;
			br.readLine();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(sb.toString());
	}
}