package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj20923 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<Integer> dodo = new ArrayDeque<>();
	static Deque<Integer> su = new ArrayDeque<>();
	static int N, M;

	static void func() {
		Deque<Integer> left = new ArrayDeque<>(); //do
		Deque<Integer> right = new ArrayDeque<>(); //su
		int l = 0;
		int r = 0;
		boolean turn = false;
		while (M-- > 0) {			
			if (!turn) {
				l = dodo.poll();
				left.addLast(l);
			} else {
				r = su.poll();
				right.addLast(r);
			}
			turn = !turn;
			
			if (dodo.isEmpty() || su.isEmpty())
				break;
			
			if (l == 5 || r == 5) {
				while (!right.isEmpty())
					dodo.addLast(right.pollFirst());
				while (!left.isEmpty())
					dodo.addLast(left.pollFirst());
				l = 0;
				r = 0;
			} else if ((r != 0 && l + r == 5) || (l != 0 && l + r == 5)) {
				while (!left.isEmpty())
					su.addLast(left.pollFirst());
				while (!right.isEmpty())
					su.addLast(right.pollFirst());
				l = 0;
				r = 0;
			}
		}

		if (dodo.size() > su.size())
			System.out.println("do");
		else if (dodo.size() < su.size())
			System.out.println("su");
		else
			System.out.println("dosu");
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dodo.addFirst(Integer.parseInt(st.nextToken()));
			su.addFirst(Integer.parseInt(st.nextToken()));
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}