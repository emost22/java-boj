package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11502 {
    private final static int MAX = 1001;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static ArrayList<Integer> primeList = new ArrayList<>();
    private static boolean isNotPrime[] = new boolean[MAX];
    private static int N, M, x;

    private static void init() {
        isNotPrime[1] = true;
        for (int i = 2; i < MAX; i++) {
            if (isNotPrime[i]) continue;

            primeList.add(i);
            for (int j = 2; i * j < MAX; j++) {
                isNotPrime[i * j] = true;
            }
        }

        M = primeList.size();
    }

    private static void func() {
        for (int i = 0; i < M; i++) {
            int p = primeList.get(i);
            if (p >= x) break;
            for (int j = 0; j < M; j++) {
                int q = primeList.get(j);
                if (p == q) continue;
                if (p + q >= x) break;

                int k = x - p - q;
                if (!isNotPrime[k]) {
                    int tmp[] = {p, q, k};
                    Arrays.sort(tmp);
                    sb.append(tmp[0]).append(" ").append(tmp[1]).append(" ").append(tmp[2]).append("\n");
                    return;
                }
            }
        }

        sb.append("0\n");
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            func();
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        init();
        input();
    }
}
