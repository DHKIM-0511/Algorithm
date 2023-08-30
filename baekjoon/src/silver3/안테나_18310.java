package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안테나_18310 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] house = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(house);
		
		if(N % 2 ==0){
            System.out.println(house[N/2-1]);
        }else{
            System.out.println(house[N/2]);
        }
	}
}