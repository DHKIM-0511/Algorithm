package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3_10989 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		
		int[] cnt = new int[10001];
		
		for(int i = 0;  i< n ; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1 ; i < 10001 ; i++) {
			while(cnt[i]>0) {
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}
		System.out.println(sb);
		
		
	}
}
