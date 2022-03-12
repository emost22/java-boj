package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj4195 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Map<String, Integer> m = new HashMap<>();
	static int parent[][] = new int[200001][2];
	static int N, idx = 1;

	static int find(int v) {
		if (parent[v][0] == v)
			return parent[v][0];
		return parent[v][0] = find(parent[v][0]);

	}

	static void union(int u, int v) {
		int a = find(u);
		int b = find(v);

		if (a != b) {
			parent[a][1] += parent[b][1];
			parent[b][0] = parent[a][0];
		}
		sb.append(parent[a][1]).append("\n");
	}

	static void init() {
		for (int i = 1; i <= N * 2; i++) {
			parent[i][0] = i;
			parent[i][1] = 1;
		}
	}

	static void input() throws Exception {
		String str1, str2;
		int u, v;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		init();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			str1 = st.nextToken();
			str2 = st.nextToken();

			if (m.containsKey(str1))
				u = m.get(str1);
			else {
				m.put(str1, idx);
				u = idx++;
			}

			if (m.containsKey(str2))
				v = m.get(str2);
			else {
				m.put(str2, idx);
				v = idx++;
			}

			if (v < u) {
				int tmp = u;
				u = v;
				v = tmp;
			}

			union(u, v);
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			input();
			m.clear();
			idx = 1;
		}
		System.out.println(sb.toString());
	}
}