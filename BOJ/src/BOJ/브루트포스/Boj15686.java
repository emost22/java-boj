package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<int[]> safehouse = new ArrayList<>();
	static ArrayList<int[]> chi = new ArrayList<>();
	static ArrayList<int[]> house = new ArrayList<>();
	static int list[][];
	static int N, M, ans = 100000;

	static void func(int idx, int cnt) {
		if (cnt == M) {
			int dis = 0;
			for (int i = 0; i < house.size(); i++) {
				int x = house.get(i)[0];
				int y = house.get(i)[1];
				int sum = 100000;
				for (int j = 0; j < safehouse.size(); j++) {
					int nx = safehouse.get(j)[0];
					int ny = safehouse.get(j)[1];

					sum = Math.min(sum, Math.abs(x - nx) + Math.abs(y - ny));
				}
				dis += sum;
			}

			ans = Math.min(ans, dis);
			return;
		}

		for (int i = idx; i < chi.size(); i++) {
			safehouse.add(chi.get(i));
			func(i + 1, cnt + 1);
			safehouse.remove(safehouse.size() - 1);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if (list[i][j] == 2) {
					chi.add(new int[] { i, j });
				} else if (list[i][j] == 1) {
					house.add(new int[] { i, j });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0, 0);
		System.out.println(ans);
	}
}