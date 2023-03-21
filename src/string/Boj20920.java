package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj20920 {
    private static HashMap<String, Integer> map = new HashMap<>();
    private static int N, M;

    private static void func() {
        StringBuffer sb = new StringBuffer();
        map.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        if (o1.getKey().length() == o2.getKey().length()) {
                            return o1.getKey().compareTo(o2.getKey());
                        } else {
                            return o2.getKey().length() - o1.getKey().length();
                        }
                    } else {
                        return o2.getValue() - o1.getValue();
                    }
                })
                .collect(Collectors.toList())
                .forEach(res -> {
                    sb.append(res.getKey()).append("\n");
                });

        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            str = br.readLine();

            if (str.length() < M) continue;

            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}
