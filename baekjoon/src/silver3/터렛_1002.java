package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 터렛_1002 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= t ; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());//조
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());// 반지름
			
			int x2 = Integer.parseInt(st.nextToken());//백
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			//제곱수로 비교
			int d = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			// 중점과 반지름이 같은 경우
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);
				continue;
			}
			//두 원의 반지름 합보다 중점간 거리가 더 길 때 
			else if(d > Math.pow(r1 + r2, 2)) {
				System.out.println(0);
				continue;
			}
			//원 안에 원이 있으나 내접하지 않을 때 
			else if(d < Math.pow(r2 - r1, 2)) {
				System.out.println(0);
				continue;
			}
			//내접할 때 
			else if(d == Math.pow(r2 - r1, 2)) {
				System.out.println(1);
				continue;
			}
			//외접할 때 
			else if(d == Math.pow(r1 + r2, 2)) {
				System.out.println(1);
				continue;
			}
			else {
				System.out.println(2);
				continue;
			}
		}
    }
}