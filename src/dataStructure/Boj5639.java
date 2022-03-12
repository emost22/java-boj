package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj5639 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();

	static class tree {
		int x;
		tree llink;
		tree rlink;

		tree() {
		}

		tree(int x, tree llink, tree rlink) {
			this.x = x;
			this.llink = llink;
			this.rlink = rlink;
		}
	}

	static tree node = new tree();

	static void addnode(int x) {
		tree newnode = new tree(x, null, null);

		if (node.x == 0) {
			node.x = x;
			return;
		}

		tree p = node;

		while (p != null) {
			if (p.x > x) {
				if (p.llink == null) {
					p.llink = newnode;
					break;
				} else
					p = p.llink;
			} else {
				if (p.rlink == null) {
					p.rlink = newnode;
					break;
				} else
					p = p.rlink;
			}
		}
	}

	static void postorder(tree t) {
		if (t.llink != null)
			postorder(t.llink);
		if (t.rlink != null)
			postorder(t.rlink);
		sb.append(t.x + "\n");
	}

	static void input() throws Exception {
		String st;
		while (true) {
			st = br.readLine();
			if (st == null || st.length() == 0)
				break;

			int x = Integer.parseInt(st);
			addnode(x);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		postorder(node);
		System.out.println(sb.toString());
	}
}