package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj24524 {
    private static String str, pat;
    private static HashMap<Character, Integer> map = new HashMap<>();
    private static int cnt[] = new int[26];

    private static void init() {
        for (int i = 0; i < pat.length(); i++) {
            map.put(pat.charAt(i), i);
        }
    }

    private static void func() {
        init();

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (!map.containsKey(x)) continue;

            int idx = map.get(x);
            if (idx > 0 && cnt[map.get(pat.charAt(idx - 1))] <= cnt[idx]) {
                continue;
            }

            cnt[idx]++;
        }

        System.out.println(cnt[map.get(pat.charAt(pat.length() - 1))]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        pat = br.readLine();
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
