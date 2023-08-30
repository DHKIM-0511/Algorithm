package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 소트인사이드_1427{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] num = reverseSort(str);
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}
	
	static int[] reverseSort(String str) {
		
		int[] num = new int[str.length()];
		
		for(int i = 0 ; i < str.length() ; i++) {
			num[i] = str.charAt(i)-'0'; 
		}
		
		for(int i = 0 ; i < num.length ; i++) {
			int maxIdx = i;
			for(int j = i + 1 ; j < num.length ; j++) {
				if(num[maxIdx] < num[j])
					maxIdx = j;
			}
			int tmp = num[i];
			num[i] = num[maxIdx];
			num[maxIdx] = tmp;
		}
		
		return num;
	}
	
}