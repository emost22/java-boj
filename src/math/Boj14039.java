package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14039 {
    private static final int MAX = 4;
    private static int list[][];

    private static void func() {
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < MAX; i++) {
            int sum = 0;
            for (int j = 0; j < MAX; j++) {
                sum += list[i][j];
            }

            if (pre == Integer.MAX_VALUE) pre = sum;
            else if (pre != sum) {
                System.out.println("not magic");
                return;
            }
        }

        for (int j = 0; j < MAX; j++) {
            int sum = 0;
            for (int i = 0; i < MAX; i++) {
                sum += list[i][j];
            }

            if (pre != sum) {
                System.out.println("not magic");
                return;
            }
        }

        System.out.println("magic");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
