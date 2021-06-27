package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj1822 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Set<Integer> s = new HashSet<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static int N, M;
	
	static void print() {
		StringBuffer sb = new StringBuffer();
		sb.append(s.size()).append("\n");
		Iterator<Integer> iter = s.iterator();
		while(iter.hasNext()) {
			list.add(iter.next());
		}
		
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
	}

	static void input() throws Exception {
		int x;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			x = Integer.parseInt(st.nextToken());
			s.add(x);
		}

		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			x = Integer.parseInt(st.nextToken());
			if (s.contains(x))
				s.remove(x);
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		print();
	}
}