package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 퍼펙트셔플_3499 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=t ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<String> deck1 = new LinkedList<String>();
			Queue<String> deck2 = new LinkedList<String>();
			if(n%2 ==0) {
				for(int i = 0 ; i < n/2 ; i++) 
					deck1.offer(st.nextToken());
			}else {
				for(int i = 0 ; i < n/2+1 ; i++) 
					deck1.offer(st.nextToken());
			}
			for(int i = 0 ; i < n/2 ; i++) 
				deck2.offer(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			
			while(!deck2.isEmpty()) {
				sb.append(deck1.poll()).append(" ");
				sb.append(deck2.poll()).append(" ");
			}
				
			if(deck1.size()>0)
				sb.append(deck1.poll());
				
			System.out.println("#"+tc+" "+sb);
		}
	}
}
