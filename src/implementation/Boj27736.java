package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj27736 {
    private static int list[];
    private static int N;

    private static void func() {
        int a = 0;
        int r = 0;
        int g = 0;
        for (int i = 0; i < N; i++) {
            if (list[i] == 1) a++;
            else if (list[i] == -1) r++;
            else g++;
        }

        if ((g << 1) >= N) System.out.println("INVALID");
        else if (a > r) System.out.println("APPROVED");
        else System.out.println("REJECTED");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N];

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
