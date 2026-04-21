package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj25516 {
    private static ArrayList<Integer> list[];
    private static int cnt[];
    private static int N, K;

    private static void func() {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean visit[] = new boolean[N];
        visit[0] = true;

        int ret = cnt[0];
        while (K-- > 0) {
            int qSize = q.size();
            while (qSize-- > 0) {
                int x = q.poll();

                for (int nx : list[x]) {
                    if (visit[nx]) continue;

                    q.add(nx);
                    visit[nx] = true;
                    ret += cnt[nx];
                }
            }
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        cnt = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        int x, y;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
