package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_1209 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		for(int tc = 0 ; tc < 10 ; tc++){
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int sum = 0;
			int max = 0;
			
			for(int i = 0 ; i <100 ; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j<100;j++)  // 배열 받기
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ; i <100 ; i++) // 행의 합 중 최댓값 구하기
			{
					
				for(int j = 0 ; j<100;j++) 
				{
					sum+=arr[i][j];
				}
				if(max <= sum) 
					max=sum;
				sum=0;
			}
				
			for(int i = 0 ; i <100 ; i++) // 열의 합 중 최댓값 구하기
			{
					
				for(int j = 0 ; j<100;j++) 
				{
					sum+=arr[j][i];
				}
				if(max<=sum) 
					max=sum;
				
				sum=0;
			}
				
			for(int i = 0 ; i <100 ; i++) // 대각1의 합 구하기
			{
				sum +=arr[i][i];				
			}
			if(max<=sum) 
				max=sum;
			
			sum=0;
			
			for(int i = 0 ; i <100 ; i++) // 대각2의 합 구하기
			{
				sum +=arr[99-i][i];				
			}
			if(max<=sum) 
				max=sum;
			
			System.out.println("#"+n+" "+max);
			
		}
	}
}
