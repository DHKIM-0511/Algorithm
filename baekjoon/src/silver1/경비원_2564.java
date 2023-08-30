package silver1;

import java.util.Scanner;

public class 경비원_2564 {
	static int d;
	static int x,y,n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		
		n = sc.nextInt();
		int[][] store = new int[n][2];
		for(int i = 0 ; i< n ; i++) {
			store[i][0] = sc.nextInt();
			store[i][1] = sc.nextInt();
		}
		int[][] dg = new int[1][2];
		dg[0][0] = sc.nextInt();
		dg[0][1] = sc.nextInt();
		
		distanceSum(store, dg);
		System.out.println(d);
	}
	private static void distanceSum(int[][] store, int[][] dg) {
		int line = dg[0][0]; // 1: 상 2: 하 3: 좌 4: 우
		int idx = dg[0][1]; // 기준(1,2:좌 , 3,4:상)에서 떨어진 거리
		//idx = 4 이면 0123
		
		for(int i = 0 ; i < n ; i++) {
			
			if(line == 1) {
				if(store[i][0] == 1) {
					d+= Math.abs(idx-store[i][1]);
				}else if(store[i][0] == 2) {
					int min = y+idx+store[i][1];
					if(min > y+(x-idx)+(x-store[i][1]))
						min =y+(x-idx)+(x-store[i][1]);
					d+=min;
				}else if(store[i][0] == 3) {
					d = d + idx + store[i][1];
				}else {
					d = d+ (x-idx) + store[i][1];
				}
			}
			
			else if(line == 2) {
				if(store[i][0] == 1) {
					int min = y+idx+store[i][1];
					if(min > y+(x-idx)+(x-store[i][1]))
						min =y+(x-idx)+(x-store[i][1]);
					d+=min;
				}else if(store[i][0] == 2) {
					d+= Math.abs(idx-store[i][1]);
				}else if(store[i][0] == 3) {
					d = d + idx + (y-store[i][1]);
				}else {
					d = d+ (x-idx) +(y-store[i][1]);
				}
			}
			
			else if(line == 3) {
				if(store[i][0] == 1) {
					d = d + idx + store[i][1];
				}else if(store[i][0] == 2) {
					d = d+ (y-idx) + store[i][1];
				}else if(store[i][0] == 3) {
					d+= Math.abs(idx-store[i][1]);
				}else {
					int min = x+idx+store[i][1];
					if(min > x+(y-idx)+(y-store[i][1]))
						min =x+(y-idx)+(y-store[i][1]);
					d+=min;
				}
			}
			
			else{
				if(store[i][0] == 1) {
					d = d+ idx + (x-store[i][1]);
				}else if(store[i][0] == 2) {
					d = d+ (y-idx) + (x-store[i][1]);
				}else if(store[i][0] == 3) {
					int min = x+idx+store[i][1];
					if(min > x+(y-idx)+(y-store[i][1]))
						min =x+(y-idx)+(y-store[i][1]);
					d+=min;
				}else {
					d+= Math.abs(idx-store[i][1]);
				}
			}
		}
	}
}
//상 , 하 상점 = 왼쪽경계로부터의 거리
//좌 , 우 상점 = 위쪽경계로부터의 거리
//마지막줄 = 동근이위치
//동근 ~ 각 상점의 최단거리의 합.