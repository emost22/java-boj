package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2999 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static char ch[][];
	static int size, N, M;

	static void func() {
		for (int i = 1; i <= size; i++) {
			if (size % i == 0) {
				if (i > size / i)
					break;
				N = i;
				M = size / i;
			}
		}

		ch = new char[N][M];
		int idx = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				ch[j][i] = str.charAt(idx++);
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(ch[i][j]);
		}
		
		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		str = br.readLine();
		size = str.length();
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}