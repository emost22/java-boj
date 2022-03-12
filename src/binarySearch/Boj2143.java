package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2143 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int A[], B[], Adp[], Bdp[];
	static ArrayList<Long> Alist, Blist;
	static int N, M;
	static long T, ans;

	static void init() {
		Alist = new ArrayList<>();
		Blist = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				Alist.add((long) (Adp[j] - Adp[i - 1]));
			}
		}

		for (int i = 1; i <= M; i++) {
			for (int j = i; j <= M; j++) {
				Blist.add((long) (Bdp[j] - Bdp[i - 1]));
			}
		}

		Collections.sort(Alist);
		Collections.sort(Blist);
	}

	static long upperbound(int l, int r, long x) {
		r++;
		while (l < r) {
			int m = (l + r) / 2;
			if (Blist.get(m) <= x)
				l = m + 1;
			else
				r = m;
		}
		return l;
	}

	static long lowerbound(int l, int r, long x) {
		r++;
		while (l < r) {
			int m = (l + r) / 2;
			if (Blist.get(m) < x)
				l = m + 1;
			else
				r = m;
		}
		return r;
	}

	static void binarysearch(int l, int r, long x) {
		if (l > r)
			return;

		int m = (l + r) / 2;
		long sum = x + Blist.get(m);
		if (sum == T) {
			ans += (upperbound(0, Blist.size() - 1, Blist.get(m)) - lowerbound(0, Blist.size() - 1, Blist.get(m)));
			return;
		} else if (sum > T)
			binarysearch(l, m - 1, x);
		else
			binarysearch(m + 1, r, x);
	}

	static void func() {
		for (int i = 0; i < Alist.size(); i++) {
			binarysearch(0, Blist.size() - 1, Alist.get(i));
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		Adp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			Adp[i] = Adp[i - 1] + A[i];
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		B = new int[M + 1];
		Bdp = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			Bdp[i] = Bdp[i - 1] + B[i];
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		init();
		func();
		System.out.println(ans);
	}
}