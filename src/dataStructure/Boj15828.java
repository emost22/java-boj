package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj15828 {
    private static Deque<Integer> q = new ArrayDeque<>();
    private static int N;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int x;
        while (true) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                if (q.isEmpty()) {
                    System.out.println("empty");
                    return;
                }

                while (!q.isEmpty()) {
                    System.out.print(q.poll() + " ");
                }
                System.out.println();
                return;
            }

            if (x == 0) {
                q.poll();
            } else {
                if (N == q.size()) continue;
                q.addLast(x);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
