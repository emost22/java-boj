package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj2109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean visit[] = new boolean[10001];
	static int list[][] = new int[10001][2];
	static int N;

	static void func() {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int d = list[i][1];

			for (int j = d; j > 0; j--) {
				if (visit[j])
					continue;

				visit[j] = true;
				ans += list[i][0];
				break;
			}
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[0] != o1[0])
					return o2[0] - o1[0];
				else
					return o2[1] - o1[1];
			}
		});
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}