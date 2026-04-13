package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj30501 {
    private static String list[];
    private static int N;

    private static void func() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < list[i].length(); j++) {
                if (list[i].charAt(j) != 'S') continue;
                
                System.out.println(list[i]);
                return;
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = st.nextToken();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
