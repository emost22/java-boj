package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1002 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();

	static class Circle {
		double x;
		double y;
		double r;
	}

	static Circle A, B;
	static double d;
	static int ans;

	static void swap() {
		Circle tmp = A;
		A = B;
		B = tmp;
	}

	static void func() {
		if (A.r > B.r) {
			swap();
		}

		if (A.x == B.x && A.y == B.y && A.r == B.r)
			ans = -1;
		else if (d == A.r + B.r)
			ans = 1;
		else if (d > A.r + B.r)
			ans = 0;
		else {
			if (d + A.r == B.r)
				ans = 1;
			else if (d + A.r > B.r)
				ans = 2;
			else
				ans = 0;
		}
	}

	static void print() {
		sb.append(ans + "\n");
		ans = 0;
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		A.x = Double.parseDouble(st.nextToken());
		A.y = Double.parseDouble(st.nextToken());
		A.r = Double.parseDouble(st.nextToken());
		
		B.x = Double.parseDouble(st.nextToken());
		B.y = Double.parseDouble(st.nextToken());
		B.r = Double.parseDouble(st.nextToken());
		d = Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			A = new Circle();
			B = new Circle();
			input();
			func();
			print();
		}
		System.out.println(sb.toString());
	}
}