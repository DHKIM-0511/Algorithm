package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보물상자비밀번호_5658 {
	static String a , b, c ,d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			int ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			a = "";
			b = "";
			c = "";
			d = "";
			
			String tmp = br.readLine();
			
			int bs = n/4;
			int cs = n/2;
			int ds = 3*n/4;
			
			for(int i = 0 ; i < n/4 ; i++) {				
				a += tmp.charAt(i);
				b += tmp.charAt(bs++);
				c += tmp.charAt(cs++);
				d += tmp.charAt(ds++);
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			ArrayList<Integer> list = new ArrayList<>();			
			
			for(int i = 0 ; i < n/4 ;i++) {
				
				pq.add(Integer.parseInt(a,16));
				pq.add(Integer.parseInt(b,16));
				pq.add(Integer.parseInt(c,16));
				pq.add(Integer.parseInt(d,16));
//				System.out.println(a+"==="+b+"==="+c+"==="+d+"===");
				shift();
			}
//			System.out.println(pq.toString());
			
			
			while(!pq.isEmpty()) {
				 boolean flag = false;
				    int value = pq.poll();
				    
				    for(int i = 0 ; i < list.size() ; i++) {
				        if(value == list.get(i)) {
				            flag = true;
				            break;
				        }    
				    }
				    
				    if(!flag) {
				        list.add(value);
				    }
//			    System.out.println(list.size());
			}

			
//			System.out.println(list.toString());
			ans = list.get(list.size()-k);
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void shift() {
		String tmp = a+b+c+d;
		
		char[] temp = new char[a.length()*4];
		temp[0] = tmp.charAt(tmp.length()-1);
		for(int i = 1 ; i < a.length()*4 ; i++) {
			temp[i] = tmp.charAt(i-1);
		}
		
		int bs = tmp.length()/4;
		int cs = tmp.length()/2;
		int ds = 3*tmp.length()/4;
		
		a="";
		b="";
		c="";
		d="";
		
		for(int i = 0 ; i < tmp.length()/4 ; i++) {				
			a += temp[i];
			b += temp[bs++];
			c += temp[cs++];
			d += temp[ds++];
		}
		
	}
}
