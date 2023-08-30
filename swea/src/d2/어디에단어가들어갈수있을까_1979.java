package d2;

import java.util.Scanner;

public class 어디에단어가들어갈수있을까_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			int[][] map = new int[n][n];
			int words = 0;
			//입력받기
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < n; i++) {
				int cnt = 0;
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 0) { //0 일때 cnt = 0 , 단어완성시엔 words++
						if(cnt == l)
							words++;
						cnt = 0;
					}
					else // 1은 그냥 ++
						cnt++;
				}
				if(cnt == l) // 반복문 끝났을떄 딱 맞으면 words++
					words++;
			}
			
			for(int j = 0; j < n; j++) {
				int cnt = 0;
				for(int i = 0; i < n; i++) {
					if(map[i][j] == 0) {
						if(cnt == l)
							words++;
						cnt = 0;
					}
					else
						cnt++;
				}
				if(cnt == l)
					words++;
			}
			System.out.println("#" + t + " " + words);
		}
	}
}