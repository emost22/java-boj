package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14456 {
    private final static int MAX = 100;
    private final static int RACE_CNT = 3;
    private static int race[] = {1, 2, 3};
    private static int list[][] = new int[MAX][2];
    private static int N;

    private static void swap(int i, int j) {
        int tmp = race[i];
        race[i] = race[j];
        race[j] = tmp;
    }

    private static boolean nextPermutation() {
        int i = RACE_CNT - 1;
        while (i > 0 && race[i - 1] > race[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = RACE_CNT - 1;
        while (race[i - 1] > race[j]) {
            j--;
        }
        swap(i - 1, j);

        int k = RACE_CNT - 1;
        while (i < k) {
            swap(i++, k--);
        }

        return true;
    }

    private static int getScore(int x, int y) {
        if (x == 1 && y == 2) {
            return 1;
        } else if (x == 2 && y == 3) {
            return 1;
        } else if (x == 3 && y == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void func() {
        int ans = 0;
        do {
            int ret = 0;
            for (int i = 0; i < N; i++) {
                ret += getScore(race[list[i][0] - 1], race[list[i][1] - 1]);
            }

            ans = Math.max(ans, ret);
        } while (nextPermutation());

        System.out.println(ans);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
