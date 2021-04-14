package BOJ.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2750_quick {
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

	static int partition(int l, int r, int pivot) {
		int pivotvalue = list[l];

		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (list[i] < pivotvalue) {
				j++;
				int tmp = list[i];
				list[i] = list[j];
				list[j] = tmp;
			}
		}

		pivot = j;
		int tmp = list[pivot];
		list[pivot] = list[l];
		list[l] = tmp;

		return pivot;
	}

	static void quickSort(int l, int r) {
		if (l < r) {
			int pivot = partition(l, r, l);
			quickSort(l, pivot - 1);
			quickSort(pivot + 1, r);
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
		quickSort(0, N - 1);
		print();
	}
}