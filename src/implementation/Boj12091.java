package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12091 {
    static String[] list = {"Vaporeon", "Jolteon", "Flareon"};

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        System.out.println(list[(N + 1) % 3]);
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
