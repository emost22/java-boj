package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1339 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int num[] = new int[26];
	static int ans;

	static void func() {
		Arrays.sort(num);
		int n = 9;
		for (int i = 25; num[i] != 0; i--) {
			ans += (num[i] * n);
			n--;
		}
		
		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			int tmp = 1;
			st = new StringTokenizer(br.readLine());
			char ch[] = st.nextToken().toCharArray();
			for (int i = ch.length - 1; i >= 0; i--) {
				num[ch[i] - 'A'] += tmp;
				tmp *= 10;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}