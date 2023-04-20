package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1337 {
    private static int list[];
    private static int N;

    private static void func() {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = i + 1; j < Math.min(N, i + 5); j++) {
                if (list[j] - list[i] < 5) cnt++;
            }

            ret = Math.max(ret, cnt);
            if (ret == 5) break;
        }

        System.out.println(5 - ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
