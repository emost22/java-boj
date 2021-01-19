package BOJ.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj20127 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<ArrayList<Integer>> inq = new LinkedList<>();
	static Queue<ArrayList<Integer>> deq = new LinkedList<>();
	static int N, inans, deans;
	static int list[] = new int[1000001];

	static void func() {
		ArrayList<Integer> newlist = new ArrayList<>();
		newlist.add(list[0]);
		for (int i = 1; i < N; i++) {
			if (list[i] >= list[i - 1])
				newlist.add(list[i]);
			else {
				inq.add(newlist);
				newlist = new ArrayList<>();
				newlist.add(list[i]);
			}
		}
		inq.add(newlist);
		if (inq.size() > 2)
			inans = -1;
		else if (inq.size() == 1)
			inans = 0;
		else {
			int size = inq.peek().size();
			int l = inq.peek().get(0);
			inq.remove();
			int r = inq.peek().get(inq.peek().size() - 1);

			if (l >= r)
				inans = size;
			else
				inans = -1;
		}

		newlist = new ArrayList<>();
		newlist.add(list[0]);
		for (int i = 1; i < N; i++) {
			if (list[i] <= list[i - 1])
				newlist.add(list[i]);
			else {
				deq.add(newlist);
				newlist = new ArrayList<>();
				newlist.add(list[i]);
			}
		}
		deq.add(newlist);

		if (deq.size() > 2)
			deans = -1;
		else if (deq.size() == 1)
			deans = 0;
		else {
			int size = deq.peek().size();
			int l = deq.peek().get(0);
			deq.remove();
			int r = deq.peek().get(deq.peek().size() - 1);

			if (r >= l)
				deans = size;
			else
				deans = -1;
		}
	}

	static void solve() {
		if (inans == -1 && deans == -1)
			System.out.println(-1);
		else if (inans == -1)
			System.out.println(deans);
		else if (deans == -1)
			System.out.println(inans);
		else
			System.out.println(Math.min(inans, deans));
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		solve();
	}
}