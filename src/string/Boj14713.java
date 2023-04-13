package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj14713 {
    private static Deque<String> q[] = new ArrayDeque[100];
    private static String strList[];
    private static int N;

    private static void func() {
        for (String str : strList) {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (str.equals(q[i].peek())) {
                    flag = true;
                    q[i].poll();
                    break;
                }
            }

            if (!flag) {
                System.out.println("Impossible");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!q[i].isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            q[i] = new ArrayDeque<>();
            for (String str : br.readLine().split(" ")) {
                q[i].add(str);
            }
        }

        strList = br.readLine().split(" ");
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
