package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj12789 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Stack<Integer> s = new Stack<>();
	static boolean chk[] = new boolean[1001];
	static int N, now = 1;

	static void input() throws Exception {
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(st.nextToken());
			if (now == x)
				now++;
			else
				s.add(x);
			
			while(!s.isEmpty() && now == s.peek()) {
				s.pop();
				now++;
			}
		}
		
		if(s.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");
	}

	public static void main(String[] args) throws Exception {
		input();
	}
}