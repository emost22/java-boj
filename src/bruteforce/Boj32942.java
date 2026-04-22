package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj32942 {
    private static final int MAX = 10;
    private static int a, b, c;

    private static void func() {
        ArrayList<Integer> ret[] = new ArrayList[MAX + 1];
        for (int x = 1; x <= MAX; x++) {
            ret[x] = new ArrayList<>();
            for (int y = 1; y <= MAX; y++) {
                if (a * x + b * y != c) continue;

                ret[x].add(y);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 10; i++) {
            if (ret[i].isEmpty()) {
                sb.append("0\n");
                continue;
            }

            for (int y : ret[i]) {
                sb.append(y).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
