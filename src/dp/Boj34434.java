package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj34434 {
    private static final int MAX = 4;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static ArrayList<Long> list = new ArrayList<>();
    private static long pat[];
    private static StringBuffer sb = new StringBuffer();

    private static void func() {
        for (int i = 0; i < Math.min(4, list.size()); i++) {
            if (pat[i] == list.get(i)) continue;
            sb.append("SNAIL\n");
            list.clear();
            return;
        }

        for (int i = 4; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) + list.get(i - 2) + list.get(i - 3) + list.get(i - 4)) continue;
            sb.append("SNAIL\n");
            list.clear();
            return;
        }

        sb.append("NAUTILUS\n");
        list.clear();
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Long.parseLong(st.nextToken()));
        }
    }

    private static void init() {
        pat = new long[MAX];
        pat[0] = 0L;
        pat[1] = 1L;
        pat[2] = 2L;
        pat[3] = 3L;
    }

    public static void main(String[] args) throws Exception {
        init();

        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            input();
            func();
        }

        System.out.print(sb.toString());
    }
}
