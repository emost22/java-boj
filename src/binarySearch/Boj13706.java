package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj13706 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static BigInteger N;

	static BigInteger binarySearch(BigInteger l, BigInteger r) {
		if (l.compareTo(r) == 1)
			return new BigInteger("-1");

		BigInteger m = l.add(r).divide(new BigInteger("2"));
		if (N.compareTo(m.multiply(m)) == 0)
			return m;
		else if (N.compareTo(m.multiply(m)) == -1)
			return binarySearch(l, m.subtract(new BigInteger("1")));
		else
			return binarySearch(m.add(new BigInteger("1")), r);

	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = new BigInteger(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(binarySearch(new BigInteger("1"), N));
	}
}