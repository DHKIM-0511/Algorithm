package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형에서탈출_1085 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		//거리 상 : h - y 하 : y 좌 : x 우 : w - x
		int[] d = { h-y , y , x , w-x};
		int min = 1001;
		
		for(int i = 0 ; i < d.length ; i++) {
			if(d[i] < min)
				min = d[i];
		}
		System.out.println(min);
	}
}
