package bronze2;

import java.util.Scanner;

public class 방배정_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 총 학생수
		int k = sc.nextInt(); // 한 방당 최대 학생 수
		int[][] student = new int[7][2];
		
		int rooms = 0;
		
		for(int i = 0 ; i < n ; i++) {
			int s = sc.nextInt(); // 0 : 여 , 1: 남
			if(s == 0) student[sc.nextInt()][0]++;
			else student[sc.nextInt()][1]++;
		}
		
		for(int i = 1 ; i < 7 ; i++) {
			if(student[i][0] == 0) continue; // 학생 수 == 0
			// 1~K-1명인경우 방 하나
			else if(student[i][0] <= k) rooms++;
			// k , 2k ...인 경우 몫만큼
			else if(student[i][0]%k == 0) rooms += student[i][0] / k;
			// 짜투리남으면 하나더
			else if(student[i][0]%k != 0) {
				rooms += student[i][0] / k;
				rooms++;
			}
		}
		for(int i = 1 ; i < 7 ; i++) {
			if(student[i][1] == 0) continue;
			
			else if(student[i][1] <= k) rooms++;
			else if(student[i][1]%k == 0) rooms += student[i][1] / k;
			else if(student[i][1]%k != 0) {
				rooms += student[i][1] / k;
				rooms++;
			}
		}
		System.out.println(rooms);
	}
}
