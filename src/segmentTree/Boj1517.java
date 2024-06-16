package segmentTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1517 {
    private static int list[][];
    private static long tree[];
    private static int N;

    private static void compress() {
        Arrays.sort(list, 0, N, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int pre = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (pre != list[i][0]) cnt++;
            pre = list[i][0];
            list[i][0] = cnt;
        }
        Arrays.sort(list, 0, N, Comparator.comparingInt(o -> o[1]));
    }

    private static long update(int node, int l, int r, int x) {
        if (x < l || r < x) return tree[node];
        if (l == r) return ++tree[node];

        int m = (l + r) >> 1;
        return tree[node] = update(node << 1, l, m, x) + update((node << 1) + 1, m + 1, r, x);
    }

    private static long query(int node, int l, int r, int s, int e) {
        if (s <= l && r <= e) return tree[node];
        if (l > e || s > r) return 0L;

        int m = (l + r) >> 1;
        return query(node << 1, l, m, s, e) + query((node << 1) + 1, m + 1, r, s, e);
    }

    private static void func() {
        compress();

        long ret = 0;
        for (int i = 0; i < N; i++) {
            ret += query(1, 1, N, list[i][0] + 1, N);
            update(1, 1, N, list[i][0]);
        }
        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N][2];
        tree = new long[(N << 2) + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}