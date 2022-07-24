package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj2338 {
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger N = new BigInteger(st.nextToken());
		st = new StringTokenizer(br.readLine());
		BigInteger M = new BigInteger(st.nextToken());
		
		System.out.println(N.add(M) + "\n" + N.subtract(M) + "\n" + N.multiply(M));
	}
	
	public static void main(String[] args) throws Exception {
		input();		
	}
}