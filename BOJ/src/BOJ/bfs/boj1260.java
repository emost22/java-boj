package BOJ.bfs;

import java.io.*;
import java.util.*;

public class boj1260 {
	static ArrayList<Integer>[] graph;
	static boolean visit[];

	static void dfs(int v) {
		visit[v]=true;
		System.out.print(v+" ");
		
		Collections.sort(graph[v]);
		for(int next: graph[v]) {
			if(visit[next]) continue;
			dfs(next);
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visit[v]=true;
		while(!q.isEmpty()) {
			int x=q.peek();
			q.remove();
			
			System.out.print(x+" ");
			
			for(int next: graph[x]) {
				if(visit[next]) continue;
				
				visit[next]=true;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		while (M-- > 0) {
			StringTokenizer uv = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(uv.nextToken());
			int v = Integer.parseInt(uv.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		visit = new boolean[N + 1];
		dfs(V);
		System.out.println("");
		visit = new boolean[N + 1];
		bfs(V);
		System.out.println("");
	}
}
