package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class 접두사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] strArr = new String[n];
		
		for (int i=0; i<n; i++) {
			strArr[i] = br.readLine();
		}
		
		Arrays.sort(strArr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s2.length(), s1.length());
			}
		});
		
		HashSet<String> set = new HashSet<>();
		
		for (String s1: strArr) {
			//초항(가장 긴거는 걍 넣음)
			if (set.size() == 0) {
				set.add(s1);
				continue;
			}
			
			boolean available= true;
			for (String s2 : set) {
				//s1이 s2의 접두사이면 0을 반환한다 
				if (s2.indexOf(s1) == 0) {
					available = false;
					break;
				}
			}
			if (available) {
				set.add(s1);
			}
		}
		System.out.println(set.size());
	}
}
