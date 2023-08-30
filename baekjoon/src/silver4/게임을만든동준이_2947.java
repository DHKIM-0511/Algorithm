package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class 게임을만든동준이_2947 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N];
		int ans = 0 ;
		
		for(int i = 0 ; i < N ; i++) {
			score[i]= Integer.parseInt(br.readLine());
		}
		
		int high = score[N-1];
		
		for(int i = N-2 ; 0 <= i ; i--) {
			while ( high <= score[i] ) {
				ans++;
				score[i]--;
			}
			
			high = score[i];
		}
		
		System.out.println(ans);
		
		Optional<Integer> i = null;
		System.out.println(i);
		System.out.println(i.isEmpty());
	}

}
