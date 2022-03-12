package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2096 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int maxdp[][], mindp[][];
	static int N, t;

	static void print() {
		t = 1 - t;
		int maxans = Math.max(maxdp[t][0], Math.max(maxdp[t][1], maxdp[t][2]));
		int minans = Math.min(mindp[t][0], Math.min(mindp[t][1], mindp[t][2]));

		System.out.println(maxans + " " + minans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		maxdp = new int[2][3];
		mindp = new int[2][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			maxdp[t][0] = Math.max(maxdp[1 - t][0], maxdp[1 - t][1]) + a;
			maxdp[t][1] = Math.max(maxdp[1 - t][0], Math.max(maxdp[1 - t][1], maxdp[1 - t][2])) + b;
			maxdp[t][2] = Math.max(maxdp[1 - t][1], maxdp[1 - t][2]) + c;

			mindp[t][0] = Math.min(mindp[1 - t][0], mindp[1 - t][1]) + a;
			mindp[t][1] = Math.min(mindp[1 - t][0], Math.min(mindp[1 - t][1], mindp[1 - t][2])) + b;
			mindp[t][2] = Math.min(mindp[1 - t][1], mindp[1 - t][2]) + c;

			
			t = 1 - t;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		print();
	}
}