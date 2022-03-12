package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3107 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer addsb = new StringBuffer();
	static StringBuffer sb = new StringBuffer();
	static char list[];
	static int chCnt[] = new int[8];
	static int N, f = -1, s = -1;

	static void func() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (list[i] == ':') {
				if (i > 0 && list[i - 1] == ':')
					s = i;
				else if (i < N - 1 && list[i + 1] == ':')
					f = i;
				else
					cnt++;
			}
		}

		if (cnt < 7) {
			if (f == 0 && s == 1) {
				for (int i = cnt; i < 7; i++) {
					addsb.append("0000:");
				}
			} else if (f == N - 2 && s == N - 1) {
				for (int i = cnt; i < 7; i++) {
					addsb.append(":0000");
				}
			} else if (s != 0) {
				addsb.append(":");
				for (int i = cnt + 1; i < 7; i++) {
					addsb.append("0000:");
				}
			}
		}

		int con = 0;
		for (int i = 0; i < N; i++) {
			if (f == i) {
				if (con > 0) {
					for (int j = con; j < 4; j++)
						sb.append(0);
					for (int j = i - con; j < i; j++)
						sb.append(list[j]);
					con = 0;
				}
				sb.append(addsb.toString());
			} else if (s == i)
				continue;
			else {
				if (list[i] != ':') {
					con++;
					if (i == N - 1) {
						for (int j = con; j < 4; j++)
							sb.append(0);
						for (int j = i - con + 1; j <= i; j++)
							sb.append(list[j]);
					}
				} else {
					for (int j = con; j < 4; j++)
						sb.append(0);
					for (int j = i - con; j <= i; j++)
						sb.append(list[j]);
					con = 0;
				}
			}
		}

		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		list = st.nextToken().toCharArray();
		N = list.length;
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}