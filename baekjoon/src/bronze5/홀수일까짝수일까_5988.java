package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 홀수일까짝수일까_5988 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			BigInteger a = new BigInteger(br.readLine());
			
			if(a.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) System.out.println("even");
			else System.out.println("odd");
		}
	}
}
