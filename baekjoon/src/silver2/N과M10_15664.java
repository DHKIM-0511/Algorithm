package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N과M10_15664 {
	static int N,M;
	static int[] num;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num=new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		getNums(0,0,new int[M]);
		set.forEach(System.out::println);
	}
	private static void getNums(int cnt, int idx, int[] sel) {
		if(cnt == M) {
			StringBuilder tmp = new StringBuilder();
			
			for(int a : sel) tmp.append(a).append(" ");
			
			set.add(tmp.toString());
		}else {
			for(int i = idx ; i< N ;i++) {
				sel[cnt] = num[i];
				getNums(cnt+1, i+1, sel);
			}
		}
	}
}
