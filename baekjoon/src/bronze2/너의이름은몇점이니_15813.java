package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 너의이름은몇점이니_15813 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		int sum = 0 ;
		String str = br.readLine();
		for(int i = 0 ; i < l ; i++) {
			sum += str.charAt(i)-'A'+1; 
		}
		System.out.println(sum);
	}
}
