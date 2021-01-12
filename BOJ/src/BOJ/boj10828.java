package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {
	static Stack<Integer> st = new Stack<>();

	static void Push(int x) {
		st.push(x);
		return;
	}

	static void Pop() {
		if (st.empty()) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(st.peek());
		st.pop();
		return;
	}
	
	static void Size() {
		System.out.println(st.size());
		return;
	}
	
	static void Empty() {
		if(st.empty())
			System.out.println("1");
		else
			System.out.println("0");
		
		return;
	}
	
	static void Top() {
		if(st.empty())
			System.out.println("-1");
		else
			System.out.println(st.peek());
		
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st1.nextToken());
		
		while(N-- > 0) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String type = st2.nextToken();
			
			if("push".equals(type)) {
				int x = Integer.parseInt(st2.nextToken());
				Push(x);
			}
			else if("pop".equals(type))
				Pop();
			else if("size".equals(type))
				Size();
			else if("empty".equals(type))
				Empty();
			else
				Top();
		}
	}
}
