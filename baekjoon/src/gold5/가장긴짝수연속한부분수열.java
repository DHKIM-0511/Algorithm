package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			if(Integer.parseInt(st.nextToken()) % 2 == 0) check[i] = true;
		}
		
		int start = 0;
		int end = 0;
		int cnt = 0;
		int maxLen = 0;
		
		//처음엔 list에 담아서 list.contains로 짝수인지 판별함 -> 시간초과
		// 생각해보니 contains를 사용할때마다 탐색을해야할거같음
		// boolean으로 짝수인지 표시만하고 넘김
		while(end < N) {
			//카운트가 K보다 낮을때 end증가
			if(cnt < K) {
				if(!check[end]) {
					cnt++;
				}
				end++;
				maxLen = Math.max(end - start - cnt, maxLen);
			}else if(check[end]) {
				end++;
				maxLen = Math.max(end - start - cnt, maxLen);
			}else {
				//카운트가 K 이상일때 start증가 
				if(!check[start]) {
					cnt--;
				}
				start++;
			}
		}
		System.out.println(maxLen);
	}
}
