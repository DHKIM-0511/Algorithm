package bronze4;

import java.util.Scanner;

public class HelloJudge_9316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1 ; i <= N ; i++) {
			sb.append("Hello World, Judge ").append(i).append("!").append("\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
}
