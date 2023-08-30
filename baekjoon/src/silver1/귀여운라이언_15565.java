package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 귀여운라이언_15565 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>(); // lion인형 인덱스의 리스트로 접근
		
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[i] == 1) list.add(i);
		}
		
		if (list.size() < K) { // 라이언이 K보다 적으면 불가능
            System.out.println(-1); 
        }else {
        	int ans = Integer.MAX_VALUE;
        	
        	for(int i = 0 ; i <list.size()-K+1 ; i++) {
        		int end = i+K-1;// i ~ i+k-1 만큼 윈도우설정
        		
        		if(end < list.size()) {
        			ans = Math.min(ans, list.get(end) - list.get(i) + 1);
        		}
        	}
        	System.out.println(ans);
        }
	}
}
