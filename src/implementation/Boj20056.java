package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj20056 {
	static class Pair {
		int x;
		int y;
		int m;
		int s;
		int d;

		public Pair(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static ArrayList<Pair> list = new ArrayList<>();
	static ArrayList<int[]> move[][];
	static int N, M, K;

	static void print() {
		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			ans += list.get(i).m;
		}

		System.out.println(ans);
	}

	static void func() {
		while (K-- > 0) {
			for (int i = 0; i < list.size(); i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				int m = list.get(i).m;
				int s = list.get(i).s;
				int d = list.get(i).d;

				int nx = (x + direct[d][0] * s + N * s) % N;
				int ny = (y + direct[d][1] * s + N * s) % N;
				move[nx][ny].add(new int[] { m, s, d });
			}
			list.clear();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (move[i][j].size() == 0)
						continue;
					if (move[i][j].size() == 1) {
						list.add(new Pair(i, j, move[i][j].get(0)[0], move[i][j].get(0)[1], move[i][j].get(0)[2]));
						move[i][j] = new ArrayList<>();
						continue;
					}

					int msum = 0;
					int ssum = 0;
					int odd = 0;
					for (int k = 0; k < move[i][j].size(); k++) {
						msum += move[i][j].get(k)[0];
						ssum += move[i][j].get(k)[1];
						if ((move[i][j].get(k)[2] & 1) == 1)
							odd++;
					}

					int newm = msum / 5;
					int news = ssum / move[i][j].size();
					if (newm == 0) {
						move[i][j] = new ArrayList<>();
						continue;
					}

					if (odd == 0 || move[i][j].size() == odd) {
						list.add(new Pair(i, j, newm, news, 0));
						list.add(new Pair(i, j, newm, news, 2));
						list.add(new Pair(i, j, newm, news, 4));
						list.add(new Pair(i, j, newm, news, 6));
					} else {
						list.add(new Pair(i, j, newm, news, 1));
						list.add(new Pair(i, j, newm, news, 3));
						list.add(new Pair(i, j, newm, news, 5));
						list.add(new Pair(i, j, newm, news, 7));
					}

					move[i][j] = new ArrayList<>();
				}
			}
		}
	}

	static void input() throws Exception {
		int r, c, m, s, d;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		move = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				move[i][j] = new ArrayList<>();
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			list.add(new Pair(r - 1, c - 1, m, s, d));
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}