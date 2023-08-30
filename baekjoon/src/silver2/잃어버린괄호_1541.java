package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호_1541 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int diff = Integer.MAX_VALUE;
		//- 기준으로 토큰 나누기
		StringTokenizer stm =new StringTokenizer(br.readLine(),"-");
		
		while(stm.hasMoreTokens()) {
			int tmp = 0;
			StringTokenizer stp = new StringTokenizer(stm.nextToken(),"+");
			
			// 그안에서 + 기준으로 나누어 모두 더함
			while(stp.hasMoreTokens()) {
				tmp += Integer.parseInt(stp.nextToken());
			}
			//처음 토큰은 초기값
			if(diff == Integer.MAX_VALUE) diff = tmp;
			//그 이후는 빼기
			else diff -=tmp;
		}
		System.out.println(diff);
	}
}
