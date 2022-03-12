package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1120 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[] A, B;
	static int Asize, Bsize, ans = 51;

	static void func() {
		for (int i = 0; i <= Bsize - Asize; i++) {
			int cnt = 0;
			for (int j = 0; j < Asize; j++) {
				if (A[j] != B[i + j])
					cnt++;
			}

			ans = Math.min(ans, cnt);
		}

		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		A = st.nextToken().toCharArray();
		B = st.nextToken().toCharArray();
		Asize = A.length;
		Bsize = B.length;
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}