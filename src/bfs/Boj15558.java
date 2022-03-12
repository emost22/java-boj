package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj15558 {
	static char list[][];
	static boolean visit[][];
	static int N, K;

	static int bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.push(new int[] { 0, 0 });
		visit[0][0] = true;
		for (int t = 0; !q.isEmpty(); t++) {
			int qsize = q.size();

			while (qsize-- > 0) {
				int x = q.peekFirst()[0];
				int y = q.pollFirst()[1];

				if (y + K >= N)
					return 1;
				else {
					if (!visit[1 - x][y + K] && list[1 - x][y + K] == '1') {
						q.addLast(new int[] { 1 - x, y + K });
						visit[1 - x][y + K] = true;
					}
				}
				
				if (y + 1 == N)
					return 1;
				else {
					if (!visit[x][y + 1] && list[x][y + 1] == '1') {
						q.addLast(new int[] { x, y + 1 });
						visit[x][y + 1] = true;
					}
				}

				if (y - 1 >= t + 1) {
					if (!visit[x][y - 1] && list[x][y - 1] == '1') {
						q.addLast(new int[] { x, y - 1 });
						visit[x][y - 1] = true;
					}
				}
			}
		}

		return 0;
	}

	static void func() {
		System.out.println(bfs());
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new char[2][N];
		visit = new boolean[2][N];

		st = new StringTokenizer(br.readLine());
		list[0] = st.nextToken().toCharArray();

		st = new StringTokenizer(br.readLine());
		list[1] = st.nextToken().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}