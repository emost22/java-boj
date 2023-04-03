package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5789 {
    private static String str;
    private static int N;

    private static void func() {
        int length = str.length();
        if (str.charAt(length / 2) == str.charAt(length / 2 - 1)) System.out.println("Do-it");
        else System.out.println("Do-it-Not");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            func();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
