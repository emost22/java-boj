package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj25192 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashSet<String> s = new HashSet<>();
    private static int N;

    private static void func() throws Exception {
        String str;
        int ret = 0;
        while (N-- > 0) {
            str = br.readLine();

            if ("ENTER".equals(str)) {
                s.clear();
            } else {
                if (!s.contains(str)) {
                    ret++;
                    s.add(str);
                }
            }
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
