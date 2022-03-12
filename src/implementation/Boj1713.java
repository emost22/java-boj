package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1713 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> vote = new ArrayList<>();
	static ArrayList<Pair> list = new ArrayList<>();
	static int N, K;
	static boolean visit[] = new boolean[101];

	static class Pair {
		int x;
		int cnt;
		int time;
	}
	
	static void solve() {
		int ans[]=new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			ans[i]=list.get(i).x;
		}
		Arrays.sort(ans);
		
		for(int num: ans) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	
	static void func() {
		for (int i = 0; i < K; i++) {
			Pair p = new Pair();
			p.x = vote.get(i);
			p.cnt = 1;
			p.time = i;
			if (visit[vote.get(i)]) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).x == vote.get(i)) {
						p.cnt = list.get(j).cnt + 1;
						p.time = list.get(j).time;
						list.set(j, p);
						break;
					}
				}
			} else {
				if (list.size() < N) {
					list.add(p);
					visit[vote.get(i)] = true;
				} else {
					int mini = 0;
					int mintime = 10000;
					int mincnt = 10000;
					for (int j = 0; j < list.size(); j++) {
						if (mincnt > list.get(j).cnt) {
							mini = j;
							mintime = list.get(j).time;
							mincnt = list.get(j).cnt;
						} else if (mincnt == list.get(j).cnt) {
							if (mintime > list.get(j).time) {
								mini = j;
								mintime = list.get(j).time;
								mincnt = list.get(j).cnt;
							}
						}
					}

					visit[list.get(mini).x] = false;
					list.remove(mini);
					visit[vote.get(i)] = true;
					list.add(p);
				}
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			vote.add(Integer.parseInt(st.nextToken()));
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
		solve();
	}
}