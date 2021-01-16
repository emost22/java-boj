package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3055 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char list[][] = new char[50][50];
	static boolean qvisit[][] = new boolean[50][50];
	static boolean wvisit[][] = new boolean[50][50];
	static int N, M, ex, ey;
	static Queue<int[]> q = new LinkedList<>();
	static Queue<int[]> w = new LinkedList<>();
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static void waterbfs() {
		int size = w.size();
		while (size-- > 0) {
			int x=w.peek()[0];
			int y=w.peek()[1];
			w.remove();
			
			for(int i=0; i<4; i++) {
				int nx=x+direct[i][0];
				int ny=y+direct[i][1];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M)
					continue;
				if(wvisit[nx][ny] || list[nx][ny]=='X' || list[nx][ny]=='D')
					continue;
				
				w.add(new int[] {nx,ny});
				wvisit[nx][ny]=true;
			}
		}
	}

	static boolean bfs() {
		int size=q.size();
		while(size-->0) {
			int x=q.peek()[0];
			int y=q.peek()[1];
			q.remove();
			
			for(int i=0; i<4; i++) {
				int nx=x+direct[i][0];
				int ny=y+direct[i][1];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M)
					continue;
				if(qvisit[nx][ny] || wvisit[nx][ny] || list[nx][ny]=='X')
					continue;
				if(nx==ex && ny==ey) 
					return true;
				
				q.add(new int[] {nx,ny});
				qvisit[nx][ny]=true;
			}
		}
		return false;
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				char ch = list[i][j];
				if (ch == 'S') {
					q.add(new int[] { i, j });
					qvisit[i][j] = true;
				} else if (ch == '*') {
					w.add(new int[] { i, j });
					wvisit[i][j] = true;
				} else if (ch == 'D') {
					ex = i;
					ey = j;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		for(int T=1; ; T++) {
			waterbfs();
			if(bfs()) {
				System.out.println(T);
				break;
			}
			
			if(q.isEmpty()) {
				System.out.println("KAKTUS");
				break;
			}
		}
	}
}
