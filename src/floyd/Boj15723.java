package floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15723 {
    private final static int MAX = 26;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static boolean flag[][] = new boolean[MAX][MAX];
    private static int N, M;

    private static void func() throws Exception {
        for (int k = 0; k < MAX; k++) {
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    if (flag[i][j]) continue;

                    flag[i][j] = flag[i][k] & flag[k][j];
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        String str[];
        StringBuffer sb = new StringBuffer();
        while (M-- > 0) {
            str = br.readLine().split(" ");
            sb.append(flag[str[0].charAt(0) - 'a'][str[2].charAt(0) - 'a'] ? "T\n" : "F\n");
        }

        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        String str[];
        while (N-- > 0) {
            str = br.readLine().split(" ");
            flag[str[0].charAt(0) - 'a'][str[2].charAt(0) - 'a'] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
