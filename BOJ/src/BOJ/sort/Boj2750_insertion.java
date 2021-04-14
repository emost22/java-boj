package BOJ.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2750_insertion {
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

	static void insertionSort() {
		for (int i = 0; i < N; i++) {
			int idx = i;
			for (int j = i - 1; j >= 0; j--) {
				if (list[idx] < list[j]) {
					int tmp = list[idx];
					list[idx] = list[j];
					list[j] = tmp;
					idx = j;
				}
				else
					break;
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
		insertionSort();
		print();
	}
}