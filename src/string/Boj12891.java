package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {
    private static String str;
    private static int minCnt[] = new int[4];
    private static int cnt[] = new int[4];
    private static int N, M;

    private static int getIndex(char x) {
        if (x == 'A') {
            return 0;
        } else if (x == 'C') {
            return 1;
        } else if (x == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

    private static int isPassword() {
        if (minCnt[0] > cnt[0] || minCnt[1] > cnt[1] || minCnt[2] > cnt[2] || minCnt[3] > cnt[3]) return 0;
        else return 1;
    }

    private static void func() {
        for (int i = 0; i < M; i++) {
            int idx = getIndex(str.charAt(i));
            cnt[idx]++;
        }

        int ret = isPassword();
        for (int i = M; i < N; i++) {
            int idx = getIndex(str.charAt(i));
            cnt[idx]++;

            idx = getIndex(str.charAt(i - M));
            cnt[idx]--;

            ret += isPassword();
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        str = br.readLine();

        st = new StringTokenizer(br.readLine());
        minCnt[0] = Integer.parseInt(st.nextToken());
        minCnt[1] = Integer.parseInt(st.nextToken());
        minCnt[2] = Integer.parseInt(st.nextToken());
        minCnt[3] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
