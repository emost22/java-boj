package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1039 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean visit[][] = new boolean[1000001][11];
	static int N, K, ans = -1;

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { N, 0 });
		visit[N][0] = true;

		while (!q.isEmpty()) {
			int xx = q.peek()[0];
			char x[] = Integer.toString(xx).toCharArray();
			int cnt = q.peek()[1];
			q.remove();

			if (cnt == K) {
				ans = Math.max(ans, xx);
				continue;
			}

			char newx[];
			for (int i = 0; i < x.length; i++) {
				for (int j = i + 1; j < x.length; j++) {
					if (i == 0 && x[j] == '0')
						continue;

					newx = x.clone();
					char temp = newx[i];
					newx[i] = newx[j];
					newx[j] = temp;

					int y = Integer.parseInt(String.valueOf(newx));
					if (!visit[y][cnt + 1]) {
						q.add(new int[] { y, cnt + 1 });
						visit[y][cnt + 1] = true;
					}
				}
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
		System.out.println(ans);
	}
}