package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1124 {
    private final static int MAX = 100001;
    private static int cnt[] = new int[MAX];
    private static boolean isNotPrime[] = new boolean[MAX];
    private static int l, r;

    private static void init() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i < MAX; i++) {
            if (isNotPrime[i]) continue;

            for (int j = 2; i * j < MAX; j++) {
                isNotPrime[i * j] = true;
                int tmp = i * j;
                while (tmp % i == 0) {
                    cnt[i * j]++;
                    tmp /= i;
                }
            }
        }
    }

    private static void func() {
        init();

        int ret = 0;
        for (int i = l; i <= r; i++) {
            if (!isNotPrime[cnt[i]]) ret++;
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
