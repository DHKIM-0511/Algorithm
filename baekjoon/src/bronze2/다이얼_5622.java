package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다이얼_5622 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		int sum = 0;
		
		for(int i= 0 ; i < a.length() ; i++)
		{
			if('A'<=a.charAt(i)&&'C'>=a.charAt(i))
				sum +=3;
			else if('D'<=a.charAt(i)&&'F'>=a.charAt(i))
				sum +=4;
			else if('G'<=a.charAt(i)&&'I'>=a.charAt(i))
				sum +=5;
			else if('J'<=a.charAt(i)&&'L'>=a.charAt(i))
				sum +=6;
			else if('M'<=a.charAt(i)&&'O'>=a.charAt(i))
				sum +=7;
			else if('P'<=a.charAt(i)&&'S'>=a.charAt(i))
				sum +=8;
			else if('T'<=a.charAt(i)&&'V'>=a.charAt(i))
				sum +=9;
			else if('W'<=a.charAt(i)&&'Z'>=a.charAt(i))
				sum +=10;
			
		}
		System.out.println(sum);
	}
}
