package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj14405 {
    private static String str;

    private static void func() {
        int N = str.length();

        int i = 0;
        while (i < N) {
            if (str.charAt(i) == 'p') {
                if (i + 1 >= N || str.charAt(i + 1) != 'i') {
                    System.out.println("NO");
                    return;
                }
                i += 2;
            } else if (str.charAt(i) == 'k') {
                if (i + 1 >= N || str.charAt(i + 1) != 'a') {
                    System.out.println("NO");
                    return;
                }
                i += 2;
            } else if (str.charAt(i) == 'c') {
                if (i + 2 >= N || str.charAt(i + 1) != 'h' || str.charAt(i + 2) != 'u') {
                    System.out.println("NO");
                    return;
                }
                i += 3;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
