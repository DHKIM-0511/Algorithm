package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int n = Integer.parseInt(br.readLine());
		long[] load = new long[n-1];
		long[] city = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n-1 ; i++) load[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) city[i] = Integer.parseInt(st.nextToken());
		
		long min = city[0];
		long sum = 0;
		
		for(int i = 1 ; i < n ; i++) {
			if(min > city[i]) { 
				sum += (min * load[i-1]);
				min = city[i];
			}else {
				sum += min *load[i-1];
			}
		}
		
		System.out.println(sum);
	}
}
