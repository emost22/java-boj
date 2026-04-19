package constructive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj24912 {
    private static int list[];
    private static int N;

    private static void func() {
        for (int i = 1; i <= N; i++) {
            if (list[i] > 0) {
                if (list[i - 1] == list[i] || list[i] == list[i + 1]) {
                    System.out.println(-1);
                    return;
                }
                
                continue;
            }

            if (list[i - 1] != 1 && list[i + 1] != 1) list[i] = 1;
            else if (list[i - 1] != 2 && list[i + 1] != 2) list[i] = 2;
            else if (list[i - 1] != 3 && list[i + 1] != 3) list[i] = 3;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(list[1]);
        for (int i = 2; i <= N; i++) {
            sb.append(" ").append(list[i]);
        }

        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
