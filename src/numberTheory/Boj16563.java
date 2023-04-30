package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj16563 {
    private final static int MAX = 5000001;
    private static ArrayList<Integer> prime = new ArrayList<>();
    private static boolean isNotPrime[] = new boolean[MAX];
    private static int list[] = new int[MAX];
    private static int N;

    private static void init() {
        for (int i = 2; i < MAX; i++) {
            if (isNotPrime[i]) continue;

            prime.add(i);
            for (int j = 2; i * j < MAX; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    private static void func() {
        init();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int x = list[i];
            for (int p : prime) {
                if (!isNotPrime[x]) {
                    sb.append(x).append(" ");
                    break;
                }
                
                while (x % p == 0) {
                    sb.append(p).append(" ");
                    x /= p;
                }

                if (x == 1) break;
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
