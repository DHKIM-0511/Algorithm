package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 패션왕신해빈_9375 {
	static int N,ans;
	static String[][] str;
	static String[] sel;
	static boolean[] checked;
	static HashMap<String, String> map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			N = Integer.parseInt(br.readLine()); // 의상의 수
			
//			str = new String[N][2];
			sel = new String[N];
			checked = new boolean[N];
			
			map = new HashMap<>();
			
			for(int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map.put(st.nextToken(), st.nextToken());
			}
			
			combination(0 , 0 );
			
			System.out.println(ans);
		}
	}
	private static void combination(int idx , int cnt) {
		if(cnt == N) {
			
			System.out.println(Arrays.toString(sel));
		}else {
			
			for(int i = idx ; i < N ; i++) {
				
				sel[cnt] = str[i][0];
				combination(idx+1, cnt+1);
			}
		}
	}
}
