package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이자르기_2628 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		boolean[] wArr = new boolean[w];
		boolean[] hArr = new boolean[h];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 0) { // 잘린곳 트루
				hArr[b] = true; 
			}
			if (a == 1) {
				wArr[b] = true;
			}
			
		}
		
		int maxW = 0;
		int tmp = 0;
		
		for (int i = 0; i < wArr.length; i++) {
			if (wArr[i]) {
				maxW = Math.max(maxW, tmp); // 간격 계산
				tmp = 1;
			} else
				tmp++;
		}
		maxW = Math.max(maxW, tmp);

		tmp = 0;
		int maxH = 0;
		
		for (int i = 0; i < hArr.length; i++) {
			if (hArr[i]) {
				maxH = Math.max(maxH, tmp);
				tmp = 1;
			} else
				tmp++;
		}
		maxH = Math.max(maxH, tmp);

		System.out.println(maxW * maxH);
	}
}
