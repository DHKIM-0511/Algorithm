package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_9086 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			StringBuilder sb = new StringBuilder();
			String tmp = br.readLine();
			
			if(tmp.length() == 1) {
				sb.append(tmp.charAt(0)).append(tmp.charAt(0));
			}else
				sb.append(tmp.charAt(0)).append(tmp.charAt(tmp.length()-1));
			
			System.out.println(sb);
		}
	}
}
