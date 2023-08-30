package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++)
			card[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
 
			// upperBound와 lowerBound의 차이 값을 구한다.
			sb.append(upperBound(card, key) - lowerBound(card, key)).append(' ');
		}
		System.out.println(sb);
	}

	private static int upperBound(int[] card, int key) {
		int start = 0; 
		int end = card.length; 
 
		// start가 end랑 같아질 때 까지 반복
		while (start < end) {
 
			int mid = (start + end) / 2; // 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if (key < card[mid]) {
				end = mid;
			}
			// 중복원소의 경우 else에서 처리된다.
			else {
				start = mid + 1;
			}
 
		}
 
		return start;
	}

	private static int lowerBound(int[] card, int key) {
		int start = 0; 
		int end = card.length; 
 
		while (start < end) {
 
			int mid = (start + end) / 2; // 중간위치를 구한다.
 
			/*
			 *  key 값이 중간 위치의 값보다 작거나 같을 경우
			 *  
			 *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
			 */
			if (key <= card[mid]) {
				end = mid;
			}
 
			else {
				start = mid + 1;
			}
 
		}
 
		return start;
	}
}

