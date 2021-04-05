package BOJ.분리집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1043 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int parent[] = new int[51];
	static ArrayList<Integer> list[] = new ArrayList[51];
	static boolean know[] = new boolean[51];
	static int N, M, K;

	static int find(int v) {
		if (parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}

	static void Union(int u, int v) {
		int x = find(u);
		int y = find(v);

		parent[y] = x;
		if (know[y] || know[x]) {
			know[y] = true;
			know[x] = true;
		}
	}
	
	static void func() {
		int ans = 0;
		for (int i = 0; i < M; i++) {
			boolean chk = true;
			for (int j = 0; j < list[i].size(); j++) {
				int x = list[i].get(j);

				if (know[find(x)]) {
					chk = false;
					break;
				}
			}

			if (chk)
				ans++;
		}
		
		System.out.println(ans);
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static void input() throws Exception {
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init();

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			x = Integer.parseInt(st.nextToken());
			know[x] = true;
		}

		for (int i = 0; i < M; i++) {
			int u = -1, v;
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				v = Integer.parseInt(st.nextToken());
				list[i].add(v);
				if (u == -1) {
					u = v;
					continue;
				}
				Union(u, v);
				u = v;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}