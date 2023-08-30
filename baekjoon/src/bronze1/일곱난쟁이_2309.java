package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 일곱난쟁이_2309 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] high = new int[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			high[i] = Integer.parseInt(br.readLine());
		}
		PriorityQueue<Integer> ans = new PriorityQueue<>();
		
		for(int a= 0 ; a < 9 ; a++) {
			for(int b = a+1 ; b<9 ; b++) {
				for(int c = b+1 ; c<9 ;c++) {
					for(int d = c+1 ; d<9 ;d++) {
						for(int e = d+1 ; e<9 ;e++) {
							for(int f = e+1 ; f<9 ;f++) {
								for(int g = f+1 ; g<9 ;g++) {
									if(high[a]+high[b]+high[c]+high[d]+high[e]+high[f]+high[g] ==100) {
										ans.clear();
										
										ans.offer(high[a]);
										ans.offer(high[b]);
										ans.offer(high[c]);
										ans.offer(high[d]);
										ans.offer(high[e]);
										ans.offer(high[f]);
										ans.offer(high[g]);
										
									}
								}
							}
						}
					}
				}
			}
		}
		while(!ans.isEmpty())
			System.out.println(ans.poll());
	}
}
