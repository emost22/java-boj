package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2922 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char ch[];
	static int N;
	static long ans = 0;

	static void dfs(int idx, int a, int b, long sum, boolean lChk) { // 인덱스, 자음, 모음, 합, L여부
		if (idx == N) {
			if (lChk)
				ans += sum;

			return;
		}

		if (ch[idx] == '_') {
			if (a == 2) {
				dfs(idx + 1, 0, 1, sum * 5, lChk);
			} else if (b == 2) {
				if(lChk) {
					dfs(idx + 1, 1, 0, sum * 21, lChk);
				}
				else {
					dfs(idx + 1, 1, 0, sum * 20, lChk);
					dfs(idx + 1, 1, 0, sum, true);	
				}
			} else {
				if(lChk) {
					dfs(idx + 1, a + 1, 0, sum * 21, lChk);
					dfs(idx + 1, 0, b + 1, sum * 5, lChk);
				}
				else {
					dfs(idx + 1, a + 1, 0, sum * 20, lChk);
					dfs(idx + 1, 0, b + 1, sum * 5, lChk);
					dfs(idx + 1, a + 1, 0, sum, true);	
				}
			}
		} else if (ch[idx] == 'A' || ch[idx] == 'E' || ch[idx] == 'I' || ch[idx] == 'O' || ch[idx] == 'U') {
			if (b == 2)
				return;
			dfs(idx + 1, 0, b + 1, sum, lChk);
		} else {
			if (a == 2)
				return;
			if(ch[idx]=='L')
				dfs(idx + 1, a + 1, 0, sum, true);
			else
				dfs(idx + 1, a + 1, 0, sum, lChk);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		ch = st.nextToken().toCharArray();
		N = ch.length;
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0, 0, 1, false);
		System.out.println(ans);
	}
}