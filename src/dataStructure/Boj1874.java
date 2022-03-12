package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1874 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Stack<Integer> s = new Stack<>();
	static int list[];
	static int N;

	static void func() {
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			s.add(i);
			sb.append("+\n");
			while (!s.isEmpty() && idx < N && s.peek() == list[idx]) {
				s.pop();
				sb.append("-\n");
				idx++;
			}
		}
		
		while(!s.isEmpty() && idx < N && s.peek() == list[idx]) {
			s.pop();
			sb.append("-\n");
			idx++;
		}
		if(!s.isEmpty()) {
			sb = new StringBuffer();
			sb.append("NO\n");
		}
		
		System.out.println(sb.toString());
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
		func();
	}
}