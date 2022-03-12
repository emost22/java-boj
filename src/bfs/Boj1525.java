package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj1525 {
	static class Pair {
		String now;
		int idx;
		int cnt;

		public Pair(String now, int idx, int cnt) {
			this.now = now;
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String ans = "123456780";
	static ArrayList<Integer> list[] = new ArrayList[9];
	static String str = "";

	static void init() {
		for (int i = 0; i < 9; i++)
			list[i] = new ArrayList<>();

		list[0].add(1);
		list[0].add(3);

		list[1].add(0);
		list[1].add(2);
		list[1].add(4);

		list[2].add(1);
		list[2].add(5);

		list[3].add(0);
		list[3].add(4);
		list[3].add(6);

		list[4].add(1);
		list[4].add(3);
		list[4].add(5);
		list[4].add(7);

		list[5].add(2);
		list[5].add(4);
		list[5].add(8);

		list[6].add(3);
		list[6].add(7);

		list[7].add(4);
		list[7].add(6);
		list[7].add(8);

		list[8].add(5);
		list[8].add(7);
	}

	static void bfs() {
		Set<String> s = new HashSet<>();
		Deque<Pair> dq = new ArrayDeque<>();
		dq.add(new Pair(str, str.indexOf("0"), 0));
		s.add(new String(str));
		while (!dq.isEmpty()) {
			String now = dq.peek().now;
			int idx = dq.peek().idx;
			int cnt = dq.poll().cnt;

			if (now.equals(ans)) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < list[idx].size(); i++) {
				int next = list[idx].get(i);
				char newstr[] = new String(now).toCharArray();
				char tmp = newstr[idx];
				newstr[idx] = newstr[next];
				newstr[next] = tmp;

				String s1 = String.valueOf(newstr);
				if (s.contains(s1))
					continue;

				dq.add(new Pair(s1, next, cnt + 1));
				s.add(new String(s1));
			}
		}

		System.out.println(-1);
	}

	static void input() throws Exception {
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				str += st.nextToken();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		input();
		bfs();
	}
}