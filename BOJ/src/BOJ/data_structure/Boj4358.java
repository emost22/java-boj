package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Boj4358 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String st;
	static TreeMap<String, Double> m = new TreeMap<>();
	static double N;

	static void func() {
		StringBuffer sb = new StringBuffer();
		for (Entry<String, Double> e : m.entrySet()) {
			sb.append(e.getKey() + " " + String.format("%.4f", e.getValue() * 100.0 / N) + "\n");
		}

		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		while (true) {
			st = br.readLine();
			if (st == null || st.length() == 0)
				break;

			if (m.containsKey(st)) {
				double a = m.get(st);

				m.put(st, a + 1.0);
			} else {
				m.put(st, 1.0);
			}

			N += 1.0;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}