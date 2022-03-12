package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9663 {
	static int N, ans;
	static boolean visit[][] = new boolean[15][15];
	static boolean cols[] = new boolean[15];
	static int direct[][] = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	static void dfs(int x) {
		if (x == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (cols[i])
				continue;
			boolean chk = false;
			for (int j = 0; j < 4; j++) {
				for (int k = 1;; k++) {
					int nx = x + direct[j][0] * k;
					int ny = i + direct[j][1] * k;

					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						break;
					if (visit[nx][ny]) {
						chk = true;
						break;
					}
				}
				if (chk)
					break;
			}

			if (!chk) {
				visit[x][i] = true;
				cols[i] = true;
				dfs(x + 1);
				cols[i] = false;
				visit[x][i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		dfs(0);
		System.out.println(ans);
	}
}