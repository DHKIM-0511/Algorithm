package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀빌딩_22945 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] team = new int[N];
		
		StringTokenizer st=  new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			team[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MIN_VALUE;
		
		int start = 0;
		int end = N-1;
			
		while(start < end) {
			int devCnt = end-start-1;
			
			ans = Math.max(ans, devCnt * Math.min(team[start], team[end]));
			
			//1. end를 start+2로 두고하면 완전탐색으로 시간초과남 -> end를 끝에서부터 줄임
			//2. 능력치가 작은 개발자를 바꿔주면서 팀 최대값을 갱신함
			if(team[start] < team[end]) {
				start++;
			}else {
				end--;
			}
		}
		
		System.out.println(ans);
	}
}
