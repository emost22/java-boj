package adHoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj23253 {
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M, K, x;
        boolean flag = true;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int pre = 2147483647;
            for (int j = 0; j < K; j++) {
                x = Integer.parseInt(st.nextToken());
                if (pre < x) {
                    flag = false;
                }
                pre = x;
            }
        }

        System.out.println(flag ? "Yes" : "No");
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
