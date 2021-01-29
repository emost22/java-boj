package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2422 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean noMix[][];
	static int list[] = new int[3];
	static int N, M, ans;

	static void func(int pre, int now, int cnt) {
		if (cnt == 3) {
			ans++;
			return;
		}

		for (int i = now + 1; i <= N; i++) {
			if (noMix[now][i])
				continue;
			if (pre != -1 && noMix[pre][i])
				continue;

			list[cnt] = i;
			func(now, i, cnt + 1);
			list[cnt] = 0;
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		noMix = new boolean[N + 1][N + 1];
		int x, y;

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			noMix[x][y] = true;
			noMix[y][x] = true;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(-1, 0, 0);
		System.out.println(ans);
	}
}