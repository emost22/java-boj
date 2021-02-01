package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2164 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<Integer> q = new LinkedList<>();
	static int N;

	static void func() {
		while (true) {
			if (q.size() == 1)
				break;
			
			q.remove();
			q.add(q.peek());
			q.remove();
		}
		
		System.out.println(q.peek());
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		init();
		func();
	}
}