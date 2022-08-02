package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj22193 {
	static int N, M;
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		BigInteger x = new BigInteger(st.nextToken());

		st = new StringTokenizer(br.readLine());
		BigInteger y = new BigInteger(st.nextToken());
		
		System.out.println(x.multiply(y));
	}
	
	public static void main(String[] args) throws Exception {
		input();
	}
}