package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Boj20299 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<int[]> ans = new ArrayList<>();
	static int list[][];
	static int N, S, M;

	static void print() {
		sb.append(ans.size() + "\n");
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)[0] + " " + ans.get(i)[1] + " " + ans.get(i)[2] + " ");
		}

		System.out.println(sb.toString());
	}

	static void func() {
		for (int i = 0; i < N; i++) {
			int x = list[i][0];
			int y = list[i][1];
			int z = list[i][2];

			if (x < M || y < M || z < M)
				continue;

			if (x + y + z < S)
				continue;
			
			ans.add(new int[] { x, y, z });
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
}