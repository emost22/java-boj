package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3182 {
    private static int nx[];
    private static int N;

    private static void func() {
        boolean visit[] = new boolean[N + 1];

        int ret = 0;
        int mx = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = i; !visit[j]; j = nx[j]) {
                visit[j] = true;
                cnt++;
            }

            if (cnt > mx) {
                ret = i;
                mx = cnt;
            }

            Arrays.fill(visit, false);
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nx = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nx[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
