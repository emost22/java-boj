package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11282 {
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        System.out.println((char)(N + 44031));
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
