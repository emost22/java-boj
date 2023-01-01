package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj11967 {
    private static class Room {
        int x, y;

        Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final static int MAX = 101;
    private static boolean visit[][] = new boolean[MAX][MAX];
    private static boolean isLighted[][] = new boolean[MAX][MAX];
    private static ArrayList<Room> roomList[][] = new ArrayList[MAX][MAX];
    private static int direct[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int N, M;

    private static boolean isConnection(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + direct[d][0];
            int ny = y + direct[d][1];

            if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
            if (visit[nx][ny]) return true;
        }

        return false;
    }

    private static int bfs(int sx, int sy) {
        Deque<Room> q = new ArrayDeque<>();
        q.add(new Room(sx, sy));
        visit[sx][sy] = true;
        isLighted[sx][sy] = true;

        int ret = 1;
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;

            for (Room room : roomList[x][y]) {
                int nx = room.x;
                int ny = room.y;

                if (visit[nx][ny]) continue;

                if (!isLighted[nx][ny]) ret++;
                isLighted[nx][ny] = true;

                if (isConnection(nx, ny)) {
                    visit[nx][ny] = true;
                    q.addLast(new Room(nx, ny));
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + direct[d][0];
                int ny = y + direct[d][1];

                if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
                if (visit[nx][ny]) continue;
                if (!isLighted[nx][ny]) continue;

                visit[nx][ny] = true;
                q.add(new Room(nx, ny));
            }
        }

        return ret;
    }

    private static void func() {
        System.out.println(bfs(1, 1));
    }

    private static void init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                roomList[i][j] = new ArrayList<>();
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        int sx, sy, ex, ey;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            roomList[sx][sy].add(new Room(ex, ey));
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
