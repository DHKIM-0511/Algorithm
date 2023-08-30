package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten_1208 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			
		int dump = Integer.parseInt(br.readLine());
		int[] high = new int[100];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 100 ; i++) {
			high[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(high);

			for(int i = 0 ; i < dump ; i++) {
				
				if(high[99] - high[0] <= 1) 					
					break;
				
				high[0]++;
				high[99]--;
				
				Arrays.sort(high);
			}

		
		
		System.out.println("#"+tc+" "+(high[99] - high[0]));
		}
		
		
		
	}
}
