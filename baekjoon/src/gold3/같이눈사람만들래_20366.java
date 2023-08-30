package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 같이눈사람만들래_20366 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine()); 
				
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < N-3 ; i ++) {
			for(int j = i+3 ; j < N ; j++) {
				//이중 반복문으로 elsa눈사람 만들기
				int elsa = input[i]+ input[j];
				int start = i+1;
				int end = j-1;
				
				while(start < end) {
					//투 포인터로 elsa 범위 안에서 anna눈사람 만들기
					int anna = input[start]+ input[end];
					
					ans = Math.min(ans, Math.abs(elsa-anna));
					if(elsa > anna) {
						start++;
					}else if(elsa < anna) {
						end--;
					}else {
						System.out.println(0);
						return ;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
