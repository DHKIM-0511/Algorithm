package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기_1244 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스위치 수
		int swN = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		//스위치 상태
		int[] sw = new int[swN];
		for(int i = 0 ; i < swN ; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		//학생 수
		int studentN = Integer.parseInt(br.readLine());
		//학생 성별 , 숫자
		
		for(int i = 0 ; i < studentN ; i++) {
			st = new StringTokenizer(br.readLine());
			sw = changeSW(sw, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		
		for(int a : sw) {			
			cnt++;
			System.out.printf("%d ",a);
			if(cnt == 20) {
				cnt = 0;
				System.out.println();
			}
		}
	}

	private static int[] changeSW(int[] sw, int gender, int num) {
		if(gender == 1) {// 남자라면
			for(int i = num - 1; i < sw.length ; i += num) 
				sw[i] = (sw[i] == 0) ? 1 : 0;
			
		} else { // 여자라면
			int length = 0;
			for(int i = 0; i < sw.length/2; i++) {
				if((num - 2 - length) >= 0 && (num + length) < sw.length) {
					if (sw[num-2-length] == sw[num+length])
						length++;
					else break;
				} else break;
			}
			for(int i = num - 1 - length; i <= num - 1 + length; i++) 
				sw[i] = (sw[i] == 0) ? 1 : 0;
		}
		return sw;
	}
}