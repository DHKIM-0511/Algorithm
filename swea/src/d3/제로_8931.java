package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class 제로_8931 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= t ;tc++) {
			int k = Integer.parseInt(br.readLine());
			int sum = 0;
			Stack<Integer> s = new Stack<>();
			for(int i = 0 ; i < k ; i++) {
				int tmp = Integer.parseInt(br.readLine());
				if(tmp > 0)
					s.push(tmp);
				else
					s.pop();
			}
			for(int i = 0 ; i < s.size() ; i++)
				sum+=s.get(i);
			System.out.println("#"+tc+" "+sum);
		}
	}
}
