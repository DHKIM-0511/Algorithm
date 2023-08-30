package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐_10845 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		int a = 0;
		
		for(int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			
			if(tmp.equals("push")) {
				a = Integer.parseInt(st.nextToken());
				q.offer(a);
			}else if(tmp.equals("pop")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(q.poll()); 
				}	
			}else if(tmp.equals("size")) {
				System.out.println(q.size());
			}else if(tmp.equals("empty")) {
				if(q.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0); 
				}	
			}else if(tmp.equals("front")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(q.peek()); 
				}
			}else if(tmp.equals("back")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(a); 
				}
			}
			
		}
	}
}
