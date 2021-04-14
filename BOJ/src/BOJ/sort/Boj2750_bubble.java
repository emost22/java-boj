package BOJ.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2750_bubble {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int list[];
	static int N;

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++)
			sb.append(list[i]).append("\n");

		System.out.println(sb.toString());
	}

	static void bubbleSort() {
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N - i; j++) {
				if (list[j - 1] > list[j]) {
					int tmp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = tmp;
				}
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bubbleSort();
		print();
	}
}