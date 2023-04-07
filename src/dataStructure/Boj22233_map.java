package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj22233_map {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashMap<String, Boolean> m = new HashMap<>();
    private static int N, M;

    private static void func() throws Exception {
        String strList[];
        StringBuffer sb = new StringBuffer();
        int ret = N;
        while (M-- > 0) {
            strList = br.readLine().split(",");
            for (String str : strList) {
                if (m.containsKey(str)) {
                    if (!m.get(str)) {
                        ret--;
                        m.put(str, true);
                    }
                }
            }

            sb.append(ret).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            m.put(st.nextToken(), false);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
