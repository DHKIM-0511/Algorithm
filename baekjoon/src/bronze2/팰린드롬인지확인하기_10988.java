package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬인지확인하기_10988 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		if(sb.toString().equals(sb.reverse().toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
			
	}
}
