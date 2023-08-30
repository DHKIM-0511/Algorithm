package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자리배정_10157 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		System.out.println(idx(c,r,k));
	}

	private static StringBuilder idx(int c, int r, int k) {
		StringBuilder sb = new StringBuilder();
		
		//처음 인덱스 : (1 , 1 )
		int x = 1;
		int y = 1;
		
		int cnt = 1; // k값과 비교할 변수
		
		int cycle = 0; // 한 싸이클 마다 바뀌는 인덱스계산을 위한 변수
		
		while(cnt!=k && cnt <= r*c) { // k값을 찾거나 모두 탐색
			while(cnt!=k && cnt <= r*c) { // while문을 어떻게 빠져나올지 고민하다 둘다 써버림
				cnt++;
				y++;
				if(y==r-cycle) break;
			}
			while(cnt!=k && cnt <= r*c) {
				cnt++;
				x++;
				if(x == c-cycle) break;
			}
			while(cnt!=k && cnt <= r*c) {
				cnt++;
				y--;
				if(y == cycle+1) break;
			}
			cycle++;
			while(cnt!=k && cnt <= r*c) { // 4번째마다 인덱스가 바뀜
				cnt++;
				x--;
				if(x == cycle+1) break;
			}
		}
		if(cnt > r*c) {
			sb.append(0);
		}else
		sb.append(x).append(" ").append(y);
		
		return sb;
	}
}
