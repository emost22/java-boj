package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj33612 {
    private static final int YEAR = 2024;
    private static final int MONTH = 8;
    private static final int MONTHS_PER_YEAR = 12;
    private static final int CNT = 7;

    private static int N;

    private static void func() {
        int y = YEAR;
        int m = MONTH + (N - 1) * CNT;
        y += ((m - 1) / MONTHS_PER_YEAR);
        m %= MONTHS_PER_YEAR;
        System.out.println(y + " " + (m == 0 ? 12 : m));
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
