package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj1194 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<int[]> dq = new ArrayDeque<>();
	static char list[][] = new char[51][51];
	static boolean visit[][][] = new boolean[51][51][64];
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M;

	static void bfs() {
		// t초, dq가 빌 때까지
		for (int t = 0; !dq.isEmpty(); t++) {
			int size = dq.size();

			// t초일 때 덱의 크기만큼 반복
			while (size-- > 0) {
				// x, y좌표, key: 현재 갖고있는 키
				int x = dq.peek()[0];
				int y = dq.peek()[1];
				int key = dq.poll()[2];

				// 탈출에 성공하면 t를 출력하고 리턴!
				if (list[x][y] == '1') {
					System.out.println(t);
					return;
				}

				for (int i = 0; i < 4; i++) {
					int nx = x + direct[i][0];
					int ny = y + direct[i][1];
					// 다음 키에 대한 정보
					int nextKey = key;

					// map 밖으로 나가면 continue
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;

					// 문이 있지만 해당 열쇠가 없으면 continue
					if ('A' <= list[nx][ny] && list[nx][ny] <= 'F') {
						int door = list[nx][ny] - 'A';

						if ((key & (1 << door)) == 0)
							continue;
					}

					// 열쇠가 있는 칸에 도달했을 때 nextKey에 찾은 열쇠를 더해주기
					if ('a' <= list[nx][ny] && list[nx][ny] <= 'f') {
						nextKey = nextKey | (1 << (list[nx][ny] - 'a'));
					}

					// 다음 칸을 이미 방문했거나 벽이면 continue
					if (visit[nx][ny][nextKey] || list[nx][ny] == '#')
						continue;

					// 모두 통과했으면 덱에 add
					dq.add(new int[] { nx, ny, nextKey });
					visit[nx][ny][nextKey] = true;
				}
			}
		}

		// 덱이 비었음에도 탈출을 하지 못했으면 -1을 출력
		System.out.println(-1);
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				// 출발지점을 미리 덱에 add
				if (list[i][j] == '0') {
					dq.add(new int[] { i, j, 0 });
					visit[i][j][0] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
}