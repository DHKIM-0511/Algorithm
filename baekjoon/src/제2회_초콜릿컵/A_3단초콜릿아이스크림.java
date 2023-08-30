package 제2회_초콜릿컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_3단초콜릿아이스크림 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			
			if(avaliable(input)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	private static boolean avaliable(String input) {
		int l = (int)Math.ceil(input.length()/3.0);
		char[] c = input.toCharArray();
		
		String S = "";
		for(int i = 0 ; i < l ;i++) S += c[i];
		if(input.equals(S + reverse(S) + S)) return true;
		if(input.equals(S + tail(reverse(S)) + S)) return true;
		if(input.equals(S + reverse(S) + tail(S))) return true;
		if(input.equals(S + tail(reverse(S)) + tail(S))) return true;
		
		return false;
	}

	private static String tail(String s) {
		char[] c = s.toCharArray();
		String tmp ="";
		
		for(int i =1 ; i < c.length ; i++) {
			tmp += c[i];
		}
		return tmp;
	}

	private static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		return sb.reverse().toString();
	}
}
