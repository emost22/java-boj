package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj6416 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Map<Integer, ArrayList<Integer>> m = new HashMap<>();
	static Set<Integer> findRoot = new HashSet<>();
	static Set<Integer> child = new HashSet<>();
	static Set<Integer> visit = new HashSet<>();
	static boolean tworoot, twoparents, cycle;
	static int u, v, root;

	static void dfs(int x) {
		visit.add(x);

		ArrayList<Integer> graph = m.get(x);
		if (graph == null)
			return;

		for (int i = 0; i < graph.size(); i++) {
			int next = graph.get(i);

			if (visit.contains(next)) {
				cycle = true;
				return;
			}

			dfs(next);
			if (cycle)
				return;
		}
	}

	static void rootFinding() {
		Iterator<Integer> iter = findRoot.iterator();
		while (iter.hasNext()) {
			int x = iter.next();

			if (!child.contains(x)) {
				if (root != 0) {
					tworoot = true;
					return;
				}
				root = x;
			}
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		while (true) {
			while (!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			if (u == 0 || u == -1)
				return;

			if (m.containsKey(u)) {
				m.get(u).add(v);
			} else {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(v);
				m.put(u, tmp);
			}
			if (child.contains(v))
				twoparents = true;
			else
				child.add(v);

			findRoot.add(u);
		}
	}

	static void clear() {
		m.clear();
		findRoot.clear();
		child.clear();
		visit.clear();
		twoparents = false;
		tworoot = false;
		cycle = false;
		root = 0;
	}

	public static void main(String[] args) throws Exception {
		for (int T = 1;; T++) {
			input();
			if (u == -1)
				break;

			sb.append("Case " + T + " is ");
			if (child.isEmpty()) {
				sb.append("a tree.\n");
				continue;
			}
			if (twoparents) {
				sb.append("not a tree.\n");
				clear();
				continue;
			}

			rootFinding();
			if (root == 0 || tworoot) {
				sb.append("not a tree.\n");
				clear();
				continue;
			}

			dfs(root);
			if (cycle)
				sb.append("not a tree.\n");
			else
				sb.append("a tree.\n");

			clear();
		}

		System.out.println(sb.toString());
	}
}