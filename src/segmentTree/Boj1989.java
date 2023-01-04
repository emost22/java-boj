package segmentTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1989 {
    private final static class Ans {
        long sum;
        int s;
        int e;

        Ans(long sum, int s, int e) {
            this.sum = sum;
            this.s = s;
            this.e = e;
        }
    }

    private final static int MAX = 100001;
    private static long sumTree[] = new long[MAX * 4];
    private static int idxTree[] = new int[MAX * 4];
    private static long list[] = new long[MAX];
    private static int N;

    private static int getMinIndexOfBoth(int i, int j) {
        if (i == -1) return j;
        else if (j == -1) return i;
        if (list[i] <= list[j]) {
            return i;
        } else {
            return j;
        }
    }

    private static long initSumTree(int node, int s, int e) {
        if (s == e) return sumTree[node] = list[s];

        int m = (s + e) >> 1;
        return sumTree[node] = initSumTree(node * 2, s, m) + initSumTree(node * 2 + 1, m + 1, e);
    }

    private static long queryOfSumTree(int node, int s, int e, int l, int r) {
        if (s > r || l > e) return 0L;
        if (l <= s && e <= r) return sumTree[node];

        int m = (s + e) >> 1;
        return queryOfSumTree(node * 2, s, m, l, r) + queryOfSumTree(node * 2 + 1, m + 1, e, l, r);
    }

    private static int initIdxTree(int node, int s, int e) {
        if (s == e) return idxTree[node] = s;

        int m = (s + e) >> 1;
        return idxTree[node] = getMinIndexOfBoth(initIdxTree(node * 2, s, m), initIdxTree(node * 2 + 1, m + 1, e));
    }

    private static int getMinIndexOfArray(int node, int s, int e, int l, int r) {
        if (s > r || l > e) return -1;
        if (l <= s && e <= r) return idxTree[node];

        int m = (s + e) >> 1;
        return getMinIndexOfBoth(getMinIndexOfArray(node * 2, s, m, l, r), getMinIndexOfArray(node * 2 + 1, m + 1, e, l, r));
    }

    private static Ans getMaxArray(Ans l, Ans m, Ans r) {
        if (l.sum >= m.sum && l.sum >= r.sum) return l;
        else if (r.sum >= l.sum && r.sum >= m.sum) return r;
        else return m;
    }

    private static Ans query(int s, int e) {
        if (s > e) return new Ans(-1L, -1, -1);
        if (s == 1 && e == 1) {
            int a = 0;
            a++;
        }

        int idx = getMinIndexOfArray(1, 1, N, s, e);
        Ans ret = new Ans(queryOfSumTree(1, 1, N, s, e) * list[idx], s, e);
        Ans l = query(s, idx - 1);
        Ans r = query(idx + 1, e);

        Ans asd = getMaxArray(l, ret, r);
        return getMaxArray(l, ret, r);
    }

    private static void func() {
        initIdxTree(1, 1, N);
        initSumTree(1, 1, N);
        Ans ans = query(1, N);
        System.out.println(ans.sum);
        System.out.println(ans.s + " " + ans.e);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
