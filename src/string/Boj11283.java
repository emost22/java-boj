package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11283 {
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println((int)str.charAt(0) - 44031);
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
