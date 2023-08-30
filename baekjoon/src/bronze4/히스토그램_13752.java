package bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 히스토그램_13752 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i ++) {
			int size = Integer.parseInt(br.readLine());
			
			for(int j = 0 ; j < size ; j++) sb.append("=");
			if(i != n-1 )sb.append("\n");
		}
		System.out.println(sb);
	}
}
