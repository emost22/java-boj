package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj4740 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();

    private static void input() throws Exception {
        String str = br.readLine();
        StringBuffer sb2 = new StringBuffer();
        sb2.append(str);
        if ("***".equals(str)) {
            System.out.print(sb.toString());
            System.exit(0);
        }

        sb.append(sb2.reverse()).append("\n");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            input();
        }
    }
}
