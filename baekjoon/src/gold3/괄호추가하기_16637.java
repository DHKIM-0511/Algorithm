package gold3;

import java.io.*;
import java.util.*;

public class 괄호추가하기_16637 {
	static int N,ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//짝수 idx = 숫자 , 홀수 idx = 기호
		char[] arr = br.readLine().toCharArray(); 
		ans = Integer.MIN_VALUE;
		
		findMax(arr);
		System.out.println(ans);
	}
	//괄호 2개는 N/2 > 0 ,괄호 3개는 N/3>0 ... 
	private static void findMax(char[] arr) {
		
		
	}
}
