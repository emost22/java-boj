package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1672 {
    private static char str[];
    private static int len;

    private static char getNext(char a, char b) {
        switch (a) {
            case 'A':
                switch (b) {
                    case 'A':
                        return 'A';
                    case 'C':
                        return 'A';
                    case 'G':
                        return 'C';
                    case 'T':
                        return 'G';
                }
                break;
            case 'C':
                switch (b) {
                    case 'A':
                        return 'A';
                    case 'C':
                        return 'C';
                    case 'G':
                        return 'T';
                    case 'T':
                        return 'G';
                }
                break;
            case 'G':
                switch (b) {
                    case 'A':
                        return 'C';
                    case 'C':
                        return 'T';
                    case 'G':
                        return 'G';
                    case 'T':
                        return 'A';
                }
                break;
            case 'T':
                switch (b) {
                    case 'A':
                        return 'G';
                    case 'C':
                        return 'G';
                    case 'G':
                        return 'A';
                    case 'T':
                        return 'T';
                }
                break;
        }
        return ' ';
    }

    private static void func() {
        while (len > 1) {
            char a = str[len - 2];
            char b = str[len - 1];
            str[len - 2] = getNext(a, b);
            len--;
        }

        System.out.println(str[0]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        str = st.nextToken().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
