package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj7510 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();
    private static int list[] = new int[3];

    private static void func(int tc) {
        Arrays.sort(list);

        sb.append("Scenario #").append(tc).append(":\n");
        if (list[0] * list[0] + list[1] * list[1] == list[2] * list[2]) {
            sb.append("yes\n");
        } else {
            sb.append("no\n");
        }
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        list[0] = Integer.parseInt(st.nextToken());
        list[1] = Integer.parseInt(st.nextToken());
        list[2] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc; t++) {
            input();
            func(t);
            if (t != tc) sb.append("\n");
        }

        System.out.print(sb);
    }
}
