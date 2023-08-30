package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자만들기_4008 {
	static int n , max, min , ans;
	static int[] cnt , nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= t ; tc++) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			cnt =  new int[4];
			for(int i = 0 ; i< 4 ; i++) cnt[i] = Integer.parseInt(st.nextToken()); // 카운팅 배열
			
			st = new StringTokenizer(br.readLine());
			nums = new int[n];
			for(int i = 0 ; i < n ;i++) nums[i] = Integer.parseInt(st.nextToken()); // 숫자 배열
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			DFS(0 , new String[n-1]);
			
			ans = max - min;
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void DFS(int idx, String[] sel) {
		if(idx == n-1) {
			System.out.println(Arrays.toString(sel));
			int[] copy = Arrays.copyOf(nums,nums.length);
			System.out.println();
			for(int i = 0 ; i< sel.length ; i++) {
				if(sel[i].equals("+")) {
					copy[i+1] = copy[i] + copy[i+1];
				}else if(sel[i].equals("-")) {
					copy[i+1] = copy[i] - copy[i+1];
				}else if(sel[i].equals("*")) {
					copy[i+1] = copy[i] * copy[i+1];
				}else {
					copy[i+1] = copy[i] / copy[i+1];
				}
			}
			int sum = copy[copy.length-1];
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			
		}else {
			for(int i = 0 ; i < 4 ; i++) {
				if(cnt[i] > 0) {
					if(i==0) {
						sel[idx] = "+";
						cnt[i]--;
						DFS(idx+1, sel);
						cnt[i]++;
					}else if(i==1) {
						sel[idx] = "-";
						cnt[i]--;
						DFS(idx+1, sel);
						cnt[i]++;
					}else if(i==2) {
						sel[idx] = "*";
						cnt[i]--;
						DFS(idx+1, sel);
						cnt[i]++;
					}else {
						sel[idx] = "/";
						cnt[i]--;
						DFS(idx+1, sel);
						cnt[i]++;
					}
				}
			}
			
		}	
	}
}
