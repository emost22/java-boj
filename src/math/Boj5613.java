package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5613 {
    private static int ret;

    private static void calc(char op, int x) {
        if (op == '+') {
            ret += x;
        } else if (op == '-') {
            ret -= x;
        } else if (op == '*') {
            ret *= x;
        } else {
            ret /= x;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ret = Integer.parseInt(st.nextToken());

        int x;
        char op;
        while (true) {
            st = new StringTokenizer(br.readLine());
            op = st.nextToken().charAt(0);
            if (op == '=') {
                System.out.println(ret);
                return;
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            calc(op, x);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
