package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_10866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			
			if(tmp.equals("push_front")) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			}else if(tmp.equals("push_back")) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}else if(tmp.equals("pop_front")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(dq.pollFirst()); 
				}	
			}else if(tmp.equals("pop_back")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(dq.pollLast()); 
				}	
			}else if(tmp.equals("size")) {
				System.out.println(dq.size());
			}else if(tmp.equals("empty")) {
				if(dq.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0); 
				}	
			}else if(tmp.equals("front")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(dq.peekFirst()); 
				}
			}else if(tmp.equals("back")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(dq.peekLast()); 
				}
			}
		}
	}
}
