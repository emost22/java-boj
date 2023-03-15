package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj14235 {
    private static PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private static int N;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int a;
        StringBuffer sb = new StringBuffer();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (q.isEmpty()) sb.append("-1\n");
                else sb.append(q.poll()).append("\n");
            }

            while (a-- > 0) {
                q.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
