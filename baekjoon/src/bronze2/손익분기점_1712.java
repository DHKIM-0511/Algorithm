package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 손익분기점_1712 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int cnt = 1, cntSum = 0;
		
		while (true) {
			
			if (x <= cntSum + cnt) {
				if (cnt % 2 == 1) {	 
					
					System.out.print((cnt - (x - cntSum - 1)) + "/" + (x - cntSum));
					break;
					}
				else {	
					System.out.print((x - cntSum) + "/" + (cnt - (x - cntSum - 1)));
					break;
					}
				}else {
					cntSum += cnt;
					cnt++;
			}
		}
	}
}


