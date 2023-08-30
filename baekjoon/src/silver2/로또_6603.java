package silver2;

import java.io.*;
import java.util.*;

public class 로또_6603 {
	static StringBuilder sb;
	static int[] num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			num = new int[k];
			for(int i = 0 ; i< k ; i++) num[i] = Integer.parseInt(st.nextToken());
			
			sb = new StringBuilder();
			combi(0,0,new int[6]);
			
			System.out.println(sb);
		}
	}

	private static void combi(int cnt,int idx, int[] sel) {
		if(cnt == 6) {
			for(int a : sel) sb.append(a).append(" ");
			sb.append("\n");
		}else {
			for(int i = idx ; i < num.length; i++) {
				sel[cnt] = num[i];
				combi(cnt+1,i+1, sel);
			}
		}
	}
}
