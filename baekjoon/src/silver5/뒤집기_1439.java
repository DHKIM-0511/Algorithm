package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기_1439 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char d = str.charAt(0);
		int cnt = 0;
		
		for(int i = 1 ; i < str.length(); i++) {
			if(str.charAt(i) != d && str.charAt(i-1) != str.charAt(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
