package BOJ.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1244 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[], student[][];
	static int N, M;

	static void solve1(int x) {
		for (int i = x; i <= N; i += x) {
			list[i] = 1 - list[i];
		}
	}

	static void solve2(int x) {
		int l = x - 1;
		int r = x + 1;
		list[x] = 1 - list[x];
		while (l >= 1 && r <= N) {
			if (list[l] == list[r]) {
				list[l] = 1 - list[l];
				list[r] = 1 - list[r];
				l--;
				r++;
			} else
				break;
		}
	}

	static void func() {
		for (int i = 0; i < M; i++) {
			int type = student[i][0];
			int x = student[i][1];

			if (type == 1)
				solve1(x);
			else
				solve2(x);
		}
	}

	static void print() {
		for (int i = 1; i <= N; i++) {
			System.out.print(list[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
		System.out.println();
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		student = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}