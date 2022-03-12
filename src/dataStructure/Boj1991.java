package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int list[][] = new int[27][2];
	static int N;

	static void preorder(int v) {
		sb.append((char) (v + 'A'));
		if (list[v][0] != -1)
			preorder(list[v][0]);
		if (list[v][1] != -1)
			preorder(list[v][1]);
	}

	static void inorder(int v) {
		if (list[v][0] != -1)
			inorder(list[v][0]);
		sb.append((char) (v + 'A'));
		if (list[v][1] != -1)
			inorder(list[v][1]);
	}

	static void postorder(int v) {
		if (list[v][0] != -1)
			postorder(list[v][0]);
		if (list[v][1] != -1)
			postorder(list[v][1]);
		sb.append((char) (v + 'A'));
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char x = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);

			if (l == '.')
				list[x - 'A'][0] = -1;
			else
				list[x - 'A'][0] = l - 'A';

			if (r == '.')
				list[x - 'A'][1] = -1;
			else
				list[x - 'A'][1] = r - 'A';

		}
	}

	public static void main(String[] args) throws Exception {
		input();
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		sb.append("\n");
		System.out.println(sb.toString());
	}
}