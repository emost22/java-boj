package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1068 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> list[];
	static int N, deleteNode, root, ans;

	static void dfs(int v) {
		if (v == deleteNode)
			return;

		if (list[v].size() == 0) {
			ans++;
			return;
		}

		for (int i = 0; i < list[v].size(); i++) {
			int next = list[v].get(i);
			
			if(list[v].size()==1 && next == deleteNode) {
				ans++;
				return;
			}
			
			dfs(next);
		}
	}

	static void input() throws Exception {
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(st.nextToken());
			if (x != -1)
				list[x].add(i);
			else
				root = i;
		}

		st = new StringTokenizer(br.readLine());
		deleteNode = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(root);
		System.out.println(ans);
	}
}