package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10773 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Stack<Integer> s = new Stack<>();
	static int N, K, ans;

	static void solve() {
		while (!s.isEmpty()) {
			int x = s.peek();
			s.pop();

			ans += x;
		}
		
		System.out.println(ans);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());

			K = Integer.parseInt(st.nextToken());
			if (K > 0) {
				s.add(K);
			} else
				s.pop();
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}