package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 비밀번호찾기_17219 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			String page = st.nextToken();
			String passWord = st.nextToken();
			
			map.put(page, passWord);
		}
		
		for(int i = 0 ; i < m ; i ++) {
			String page = br.readLine();
			System.out.println(map.get(page));
		}
	}
}
