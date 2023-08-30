package silver5;

import java.util.Scanner;

public class 영화감독숌_1436 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
 
		int startNum = 666;
		int count = 1;
        
		while(count != n) {
			startNum++;
			if(String.valueOf(startNum).contains("666")) {
				count++;
			}
		}
		System.out.println(startNum);
	}
}
