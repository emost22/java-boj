package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj15815 {
    private static String str;

    private static int calc(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a / b;
        }
    }

    private static void func() {
        Stack<Integer> s = new Stack<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char x = str.charAt(i);
            if ('0' <= x && x <= '9') {
                s.push(x - '0');
            } else {
                int b = s.pop();
                int a = s.pop();
                s.push(calc(a, b, x));
            }
        }

        System.out.println(s.pop());
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
