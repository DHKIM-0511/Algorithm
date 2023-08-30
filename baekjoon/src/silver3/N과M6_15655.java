package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M6_15655 {
	static int N,M;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken()); 
		M =Integer.parseInt(st.nextToken());
		num = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) num[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		getNums(0,0,new int[M]);
		System.out.println(sb);
	}
	private static void getNums(int cnt, int idx, int[] sel) {
		if(M == cnt) {
			for(int a : sel) sb.append(a).append(" ");
			sb.append("\n");
		}else {
			for(int i = idx ; i < N ; i++) {
				sel[cnt] = num[i];
				getNums(cnt+1 , i+1 , sel);
			}
		}
	}
}
