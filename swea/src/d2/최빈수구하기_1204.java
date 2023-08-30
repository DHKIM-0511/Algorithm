package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최빈수구하기_1204 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < tc; i ++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] cnt = new int[101];
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j <1000 ; j++)
				cnt[Integer.parseInt(st.nextToken())]++;
				
			int max = 0;
			int maxScore=0;
			
			for(int j = 0 ; j<cnt.length ; j++)
			{
				if(cnt[j]>=max) {
					max = cnt[j];
					maxScore=j;
				}
			}
			
			System.out.println("#"+n+" "+maxScore);
		}
	}
}