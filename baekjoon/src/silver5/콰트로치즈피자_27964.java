package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 콰트로치즈피자_27964 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<String> list = new LinkedList<>();
		
		out : for(int i = 0 ; i <n ; i ++) {
			String tmp = st.nextToken();
			if(isCheese(tmp)) {
				if(list.size()>0) {
					for(String next : list) {
						if(next.equals(tmp)) continue out;
					}
				}
				list.add(tmp);
			}
		}
		
		if(list.size() >=4) System.out.println("yummy");
		else System.out.println("sad");
	}

	private static boolean isCheese(String str) {
		if(str.length() < 6) return false;
		String tmp = "";
		for(int i = 6 ; i >0  ; i --) {
			tmp += str.charAt(str.length()-i);
		}
		if(tmp.equals("Cheese")) {
			return true;
		}
		return false;
	}
}
