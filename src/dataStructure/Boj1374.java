package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1374 {
    private static int[][] list;
    private static PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
    private static int N;

    private static void func() {
        Arrays.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[2] - o2[2];
            else return o1[1] - o2[1];
        });

        int ret = 0;
        for (int i = 0; i < N; i++) {
            while (!q.isEmpty() && q.peek() <= list[i][1]) q.poll();

            q.add(list[i][2]);
            ret = Math.max(ret, q.size());
        }

        System.out.println(ret);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
