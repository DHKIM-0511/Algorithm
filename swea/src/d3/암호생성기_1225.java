package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 암호생성기_1225 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 0 ; t < 10 ; t++) {
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] pw = new int[8];
		int front = 0;
		
		for(int i = 0 ; i < 8 ; i++)
			pw[i] = Integer.parseInt(st.nextToken());
		
		out:while(true) {
			
			for(int i = 1 ; i <= 5 ; i++) {
				
				pw[front] = pw[front] - i;
				
				if(pw[front] <= 0) {
					pw[front] = 0;
					front = (front+1) % 8;
					break out;
				}else
					front = (front+1) % 8;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 8 ; i++) {
			sb.append(pw[front]).append(" ");
			front = (front+1) % 8;
		}
		System.out.println("#"+tc+" "+sb);
		}
	}
		
}
