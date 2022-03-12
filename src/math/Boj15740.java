package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj15740 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static BigInteger A, B;
	
	static void input() throws Exception{
		st = new StringTokenizer(br.readLine());
		
		A = new BigInteger(st.nextToken());
		B = new BigInteger(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(A.add(B));
	}
}