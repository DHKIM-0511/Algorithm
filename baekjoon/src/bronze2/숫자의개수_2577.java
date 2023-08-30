package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수_2577 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		String ans = Integer.toString(a*b*c);
		int[] cnt = new int[10];
		
		for(int i = 0 ; i < ans.length() ; i++) {
			cnt[ans.charAt(i)-'0']++;
		}
		
		for(int x : cnt) {
			System.out.println(x);
		}
	}
}
