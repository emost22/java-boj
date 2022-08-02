package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14928 {
	static final int MOD = 20000303;
	static String str;
	
	static void func() {
		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			ans = (ans * 10 + (str.charAt(i) - '0')) % MOD;
		}
		
		System.out.println(ans);
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		str = st.nextToken();
	}
	
	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}