package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj3040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Integer> ans = new ArrayList<>();
	static int list[] = new int[9];

	static void func(int idx, int cnt, int sum) {
		if (cnt == 7) {
			if (sum != 100)
				return;

			for (int i = 0; i < 7; i++) {
				sb.append(ans.get(i) + "\n");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < 9; i++) {
			if (sum + list[i] > 100)
				continue;
			
			ans.add(list[i]);
			func(i + 1, cnt + 1, sum + list[i]);
			ans.remove(cnt);
		}
	}

	static void input() throws Exception {
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func(0, 0, 0);
		System.out.println(sb.toString());
	}
}