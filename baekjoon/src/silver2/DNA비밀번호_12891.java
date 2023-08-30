package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {
	static int A,C,G,T,a,c,g,t;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String pw = br.readLine();
		int[] ACGT = new int[4];
		st = new StringTokenizer(br.readLine());
		ACGT[0] = Integer.parseInt(st.nextToken());
		ACGT[1] = Integer.parseInt(st.nextToken());
		ACGT[2] = Integer.parseInt(st.nextToken());
		ACGT[3] = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int start = 0;
		int end = P-1;
		
		//초항
		int[] acgt = new int[4];
		for(int i = start ; i <= end ; i++) {
			
			if(pw.charAt(i) == 'A') acgt[0]++;
			else if(pw.charAt(i) == 'C') acgt[1]++;
			else if(pw.charAt(i) == 'G') acgt[2]++;
			else if(pw.charAt(i) == 'T') acgt[3]++;
		}
		
		if (isPossible(ACGT, acgt)) ans++;
		
		while(end < S) {
			// 1. start를 제외한다
			switch (pw.charAt(start)) {
			case 'A':
				acgt[0]--;
				break;
			case 'C':
				acgt[1]--;
				break;
			case 'G':
				acgt[2]--;
				break;
			case 'T':
				acgt[3]--;
				break;
			default:
				break;
			}
			start++;
			// 2. end+1을 포함시킨다. 
			if (end >= S-1) break;
			switch (pw.charAt(++end)) {
			case 'A':
				acgt[0]++;
				break;
			case 'C':
				acgt[1]++;
				break;
			case 'G':
				acgt[2]++;
				break;
			case 'T':
				acgt[3]++;
				break;
			default:
				break;
			}
			if (isPossible(ACGT, acgt)) ans++;
		}
		System.out.println(ans);
	}
	
	public static boolean isPossible(int[] ACGT, int[] acgt) {
		for (int i = 0; i < 4; i++) {
			if (acgt[i] < ACGT[i]) return false;
		}
		return true;
	}
}
