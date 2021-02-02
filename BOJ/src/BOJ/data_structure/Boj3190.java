package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj3190 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char ch[] = new char[10001];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int list[][];
	static Deque<int[]> dq = new ArrayDeque<>();
	static int N, K, L;

	static void func() {
		int idx = 0;
		dq.addLast(new int[] { 1, 1 });
		list[1][1] = 1;
		for (int T = 1;; T++) {
			int x = dq.peekFirst()[0];
			int y = dq.peekFirst()[1];

			int nx = x + direct[idx][0];
			int ny = y + direct[idx][1];
			if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
				System.out.println(T);
				return;
			}

			if (list[nx][ny] == 2) {
				dq.addFirst(new int[] { nx, ny });
			} else if (list[nx][ny] == 0) {
				dq.addFirst(new int[] { nx, ny });
				list[dq.peekLast()[0]][dq.peekLast()[1]] = 0;
				dq.removeLast();
			} else {
				System.out.println(T);
				return;
			}

			if (ch[T] == 'L')
				idx = (idx + 3) % 4;
			else if (ch[T] == 'D')
				idx = (idx + 1) % 4;

			list[nx][ny] = 1;
		}
	}

	static void input() throws Exception {
		int x, y;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			list[x][y] = 2;
		}

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		while (L-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			ch[x] = c;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}