package bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험점수_5596 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[2];
		for(int i = 0 ; i < 2 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 4 ; j++) {
				arr[i] += Integer.parseInt(st.nextToken());
			}
		}
		if(arr[0] > arr[1]) System.out.println(arr[0]);
		else System.out.println(arr[1]);
	}
}
