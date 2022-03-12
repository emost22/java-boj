package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj5397 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Deque<Character> left, right;
	static char ch[];

	static void print() {
		while(!left.isEmpty()) {
			sb.append(left.peekFirst());
			left.removeFirst();
		}
		
		sb.append("\n");
	}
	
	static void func() {
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '<') {
				if (left.isEmpty())
					continue;
				right.addFirst(left.peekLast());
				left.removeLast();
			} else if (ch[i] == '>') {
				if (right.isEmpty())
					continue;
				left.addLast(right.peekFirst());
				right.removeFirst();
			} else if (ch[i] == '-') {
				if (left.isEmpty())
					continue;
				left.removeLast();
			} else
				left.addLast(ch[i]);
		}
		
		while(!right.isEmpty()) {
			left.addLast(right.peekFirst());
			right.removeFirst();
		}
	}

	static void input() throws Exception {
		left = new ArrayDeque<>();
		right = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		ch = st.nextToken().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			func();
			print();
		}
		System.out.println(sb.toString());
	}
}