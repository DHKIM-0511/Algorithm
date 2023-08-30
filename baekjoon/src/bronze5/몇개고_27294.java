package bronze5;

import java.util.Scanner;

public class 몇개고_27294 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();// 0 ~ 11 : 아침 , 12 ~ 16 점심
		int s = sc.nextInt();// 1= 술
		
		if(t>= 12 && t<= 16  && s == 0) {
			System.out.println(320);
		}else {
			System.out.println(280);
		}
	}
}
