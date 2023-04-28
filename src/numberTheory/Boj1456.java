package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1456 {
    private final static int MAX = 10000001;
    private static boolean prime[] = new boolean[MAX];
    private static long l, r;

    private static void init() {
        for (int i = 2; i * i < MAX; i++) {
            if (prime[i]) continue;

            for (int j = 2; i * j < MAX; j++) {
                prime[i * j] = true;
            }
        }
    }

    private static void func() {
        init();

        int ret = 0;
        for (long i = 2; i * i <= r; i++) {
            if (prime[(int) i]) continue;
            long mul = i;
            while (mul <= r / i) {
                mul *= i;
                
                if (mul >= l) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Long.parseLong(st.nextToken());
        r = Long.parseLong(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
