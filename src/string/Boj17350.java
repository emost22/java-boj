package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17350 {
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        String str;
        boolean flag = false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            str = br.readLine();

            if ("anj".equals(str)) {
                flag = true;
            }
        }

        if (flag) System.out.println("뭐야;");
        else System.out.println("뭐야?");
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
