package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj22233_set {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashSet<String> s = new HashSet<>();
    private static int N, M;

    private static void func() throws Exception {
        String strList[];
        StringBuffer sb = new StringBuffer();
        while (M-- > 0) {
            strList = br.readLine().split(",");
            for (String str : strList) {
                s.remove(str);
            }

            sb.append(s.size()).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s.add(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
