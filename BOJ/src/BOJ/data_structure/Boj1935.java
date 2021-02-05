package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Stack<Double> s = new Stack<>();
	static char ch[];
	static double alphabet[] = new double[26];
	static int N;

	static void func() {
		for (char x : ch) {
			if ('A' <= x && x <= 'Z')
				s.push(alphabet[x - 'A']);
			else if (x == '+') {
				double a = s.pop();
				double b = s.pop();
				s.push(b + a);
			} else if (x == '-') {
				double a = s.pop();
				double b = s.pop();
				s.push(b - a);
			} else if (x == '*') {
				double a = s.pop();
				double b = s.pop();
				s.push(b * a);
			} else {
				double a = s.pop();
				double b = s.pop();
				s.push(b / a);
			}
		}

		System.out.printf("%.2f\n", s.pop());
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		ch = st.nextToken().toCharArray();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			alphabet[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}