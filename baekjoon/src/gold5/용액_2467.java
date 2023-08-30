package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {
	static int N;
	static int[] ans = new int[2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		find(input);
		System.out.println(ans[0]+" "+ans[1]);
	}

	private static void find(int[] input) {
		int l = 0;
	    int r = N - 1;
	    int minSum = Integer.MAX_VALUE;
	    
	    while (l < r) {
	        int sum = input[l] + input[r];
	        
	        if (Math.abs(sum) < Math.abs(minSum)) {
	            minSum = sum;
	            ans[0] = input[l];
	            ans[1] = input[r];
	        }
	        
	        if (sum < 0) {
	            l++;
	        } else if (sum > 0) {
	            r--;
	        } else {
	            break;
	        }
		}
		return;
	}
}
