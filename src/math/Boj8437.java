package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj8437 {
	static BigInteger N, M;
	
	static void func() {
		BigInteger ans = N.divide(BigInteger.valueOf(2));
		System.out.println(N.add(M).divide(BigInteger.valueOf(2)));
		System.out.println(N.subtract(M).divide(BigInteger.valueOf(2)));
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = new BigInteger(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = new BigInteger(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		input();
		func();
	}
}