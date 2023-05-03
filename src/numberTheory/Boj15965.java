package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15965 {
    private final static int MAX = 7368788;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static boolean isNotPrime[] = new boolean[MAX];
    private static int K;

    private static void init() {
        for (int i = 2; i < MAX; i++) {
            if (isNotPrime[i]) continue;

            list.add(i);
            for (int j = 2; i * j < MAX; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    private static void func() {
        init();
        System.out.println(list.get(K - 1));
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
