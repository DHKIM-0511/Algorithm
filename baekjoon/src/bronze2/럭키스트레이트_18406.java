package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키스트레이트_18406 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int sumLeft = 0;
		int sumRight = 0;
		
		for(int i = 0 ; i < str.length()/2 ; i++) {
			sumLeft += str.charAt(i)-'0';
			sumRight += str.charAt(str.length()/2+i)-'0';
		}
		
		if(sumLeft == sumRight) System.out.println("LUCKY");
		else System.out.println("READY");
	}
}
