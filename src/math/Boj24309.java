package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj24309 {
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		BigInteger b = new BigInteger(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		BigInteger c = new BigInteger(st.nextToken());
		
		System.out.println(b.subtract(c).divide(a));
	}
	
	public static void main(String[] args) throws Exception {
		input();
	}
}