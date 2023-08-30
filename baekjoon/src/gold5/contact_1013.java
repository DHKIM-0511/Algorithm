package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class contact_1013 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			String tmp = br.readLine();
			
			if(!Pattern.matches("(100+1+|01)+", tmp))
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}
