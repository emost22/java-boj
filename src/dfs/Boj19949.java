package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj19949 {
    private final static int MAX = 10;
    private static int list[] = new int[MAX];
    private static int ret;

    private static void dfs(int idx, int v, int conn, int cnt) {
        if (idx == MAX) {
            if (cnt >= 5) ret++;
            return;
        }
        if (MAX - idx + cnt < 5) return;

        for (int i = 1; i <= 5; i++) {
            if (conn == 2 && v == i) continue;

            dfs(idx + 1, i, v == i ? conn + 1 : 1, list[idx] == i ? cnt + 1 : cnt);
        }
    }

    private static void func() {
        dfs(0, 0, 0, 0);
        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < MAX; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
