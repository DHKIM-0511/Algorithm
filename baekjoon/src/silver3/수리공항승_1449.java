package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승_1449 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];//물이 세는 위치 저장
		int cnt = 1; // 하나의 테이프로 막을 수 있는 구멍 수
		
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int start = 0;
		for(int i = 1; i < N ; i++) {
			if(arr[i]-arr[start] >=L) {
				start = i;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
