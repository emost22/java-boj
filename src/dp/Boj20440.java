package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj20440 {
    private static class Point {
        int s;
        int e;

        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    private final static int MAX = 1000001;
    private static Point[] list = new Point[MAX];
    private static ArrayList<Integer> sortedList = new ArrayList<>();
    private static int dp[] = new int[MAX * 2];
    private static int N;

    private static int lowerBound(int x) {
        int l = 0;
        int r = N * 2;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (sortedList.get(m) >= x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static void compression() {
        Collections.sort(sortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        for (int i = 0; i < N; i++) {
            list[i].s = lowerBound(list[i].s);
            list[i].e = lowerBound(list[i].e);
        }
    }

    private static void func() {
        compression();
        for (int i = 0; i < N; i++) {
            dp[list[i].s]++;
            dp[list[i].e]--;
        }

        int maxValue = dp[0];
        int sIdx = 0;
        for (int i = 1; i < N * 2; i++) {
            dp[i] += dp[i - 1];
            if (dp[i] > maxValue) {
                maxValue = dp[i];
                sIdx = i;
            }
        }

        for (int i = sIdx; i <= N * 2; i++) {
            if (maxValue != dp[i]) {
                System.out.println(maxValue);
                System.out.println(sortedList.get(sIdx) + " " + sortedList.get(i));
                return;
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sortedList.add(list[i].s);
            sortedList.add(list[i].e);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
