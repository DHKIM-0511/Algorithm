package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이_14696 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int stCntA = 0;
			int ccCntA = 0;
			int sqCntA = 0;
			int trCntA = 0;
			
			int a = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < a ; j++) {
				int card = Integer.parseInt(st.nextToken());
				if(card == 4)
					stCntA++;
				else if(card == 3)
					ccCntA++;
				else if(card == 2)
					sqCntA++;
				else
					trCntA++;
			}
			
			int stCntB = 0;
			int ccCntB = 0;
			int sqCntB = 0;
			int trCntB = 0;
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < b ; j++) {
				int card = Integer.parseInt(st.nextToken());
				if(card == 4)
					stCntB++;
				else if(card == 3)
					ccCntB++;
				else if(card == 2)
					sqCntB++;
				else
					trCntB++;
			}
			
			if(stCntA > stCntB) {
				System.out.println("A");
				
			}else if(stCntA < stCntB){
				System.out.println("B");
				
			}else {
				if(ccCntA > ccCntB){
					System.out.println("A");
					
				}else if(ccCntA < ccCntB){
					System.out.println("B");
					
				}else {
					if(sqCntA > sqCntB){
						System.out.println("A");
						
					}else if(sqCntA < sqCntB){
						System.out.println("B");
						
					}else {
						if(trCntA > trCntB){
							System.out.println("A");
							
						}else if(trCntA < trCntB){
							System.out.println("B");
							
						}else {
							System.out.println("D");
						}
					}
				}
			}
			
		}
	}
}
