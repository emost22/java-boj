package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1706 {
    private final static int MAX = 20;
    private static char list[][] = new char[MAX][MAX];
    private static int N, M;

    private static void func() {
        String ret = "";

        for (int i = 0; i < N; i++) {
            String str = "";
            for (int j = 0; j < M; j++) {
                if (list[i][j] == '#') {
                    if (str.length() <= 1) {
                        str = "";
                        continue;
                    }

                    if ("".equals(ret) || ret.compareTo(str) > 0) {
                        ret = str;
                    }
                } else {
                    str += list[i][j];
                }
            }

            if (str.length() > 1) {
                if ("".equals(ret) || ret.compareTo(str) > 0) {
                    ret = str;
                }
            }
            str = "";
        }

        for (int i = 0; i < M; i++) {
            String str = "";
            for (int j = 0; j < N; j++) {
                if (list[j][i] == '#') {
                    if (str.length() <= 1) {
                        str = "";
                        continue;
                    }

                    if ("".equals(ret) || ret.compareTo(str) > 0) {
                        ret = str;
                    }
                } else {
                    str += list[j][i];
                }
            }

            if (str.length() > 1) {
                if ("".equals(ret) || ret.compareTo(str) > 0) {
                    ret = str;
                }
            }
            str = "";
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken().toCharArray();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
