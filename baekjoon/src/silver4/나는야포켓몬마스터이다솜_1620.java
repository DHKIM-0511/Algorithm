package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 포켓몬 수
		int m = Integer.parseInt(st.nextToken()); // 맞워야하는 문제 개수
		
		HashMap<Integer, String> mapIS = new HashMap<>();
		HashMap<String, Integer> mapSI = new HashMap<>();
		
		for(int i = 1 ; i <= n ; i++) { // 포켓몬 이름 입력
			String str = br.readLine();
			mapIS.put(i, str);
			mapSI.put(str, i);
		}
		
		for(int i = 0 ; i < m ; i++) {
			String str = br.readLine();
			
			if(isString(str)) {
				System.out.println(mapSI.get(str));
			}else {
				System.out.println(mapIS.get(Integer.parseInt(str)));
			}
		}
	}

	private static boolean isString(String str) {
		try {
			Integer.parseInt(str);
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
