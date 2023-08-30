package gold5;

import java.io.*;
import java.util.*;

public class AC_5430 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		out:for(int tc = 1 ; tc <= t ; tc++) {
			
			String P = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			 
			while(st.hasMoreTokens()) dq.add(Integer.parseInt(st.nextToken()));
			
			boolean front = true;
			
			for(int i = 0 ; i< P.length() ; i++) {
				if(P.charAt(i) == 'R') {
					if(front) front = false;
					else front = true;
				}
				else if(P.charAt(i) =='D') {
					if(dq.size() == 0) {
						System.out.println("error");
						continue out;
					}
					if(front) {
						dq.poll();
					}
					else dq.pollLast();
				}
			}
			
			StringBuilder ans = new StringBuilder();
			ans.append('[');
			while(!dq.isEmpty()) {
				if(front) {
					ans.append(dq.poll()).append(',');
				}else
					ans.append(dq.pollLast()).append(',');
			}
			if(ans.length()>=3)ans.delete(ans.length()-1, ans.length());
			ans.append(']');
			System.out.println(ans);
		}
	}
}
