package bronze5;

import java.util.Scanner;

public class 코딩은체육과목입니다_25314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		if(n % 4 == 0)
			n= n/4;
		else
			n= n/4+1;
		for(int i = 0 ; i < n ; i++) {
			sb.append("long ");
		}
			sb.append("int");
			System.out.println(sb);
			sc.close();
	}
}
