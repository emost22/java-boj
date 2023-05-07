package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj27522 {
    private static class Node {
        int time;
        char team;
    }

    private final static int MAX = 8;
    private final static int score[] = {10, 8, 6, 5, 4, 3, 2, 1};
    private static Node list[] = new Node[MAX];

    private static void func() {
        Arrays.sort(list, (o1, o2) -> o1.time - o2.time);

        int red = 0;
        int blue = 0;
        for (int i = 0; i < MAX; i++) {
            if (list[i].team == 'R') {
                red += score[i];
            } else {
                blue += score[i];
            }
        }

        if (red > blue) {
            System.out.println("Red");
        } else if (blue > red) {
            System.out.println("Blue");
        } else {
            if (list[0].team == 'R') {
                System.out.println("Red");
            } else {
                System.out.println("Blue");
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[];
        for (int i = 0; i < MAX; i++) {
            str = br.readLine().split(" ");

            String t[] = str[0].split(":");
            list[i] = new Node();
            list[i].time = Integer.parseInt(t[0]) * 60000 + Integer.parseInt(t[1]) * 1000 + Integer.parseInt(t[2]);
            list[i].team = str[1].charAt(0);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
