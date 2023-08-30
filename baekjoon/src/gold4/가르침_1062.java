package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침_1062 {
	static int N,K,ans;
	static String[] input;
	static boolean[] abc = new boolean[26];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // <= 50
		K = Integer.parseInt(st.nextToken()); // <= 26
		
		if( K < 5) System.out.println(0);
		else if(K == 26){
			System.out.println(N);
		}
		else{
			abc['a'-'a'] = true;
			abc['n'-'a'] = true;
			abc['t'-'a'] = true;
			abc['i'-'a'] = true;
			abc['c'-'a'] = true;
			input = new String[N];
			for(int i = 0 ; i < N ; i++) input[i] = br.readLine();
			
			ans = Integer.MIN_VALUE;
			back(0,0);
			System.out.println(ans);
		}
	}
	private static void back(int cur , int sum) {
		if(sum == K-5) {
			int cnt =0;
			for(int i= 0 ; i < N ; i++) {
				boolean read = true;
				for(int j = 4 ; j <= input[i].length()-4 ; j++) {
					if(!abc[input[i].charAt(j)-'a']) {
						read = false;
						break;
					}
				}
				if(read)cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		for(int i = cur ; i < 26 ; i++) {
			if(!abc[i]) {
				abc[i] = true;
				back(i , sum+1);
				abc[i] = false;
			}
		}
	}
}
