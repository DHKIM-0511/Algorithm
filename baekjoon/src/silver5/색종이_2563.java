package silver5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_2563 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] Paper = new int[100][100];
		int sum=0;
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken());
			for(int j = x ; j < x+10 ; j++) {
				for(int k = y ; k < y+10 ; k++) {
					Paper[j][k]=1;
				}
			}
		}
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(Paper[i][j]==1)
					sum++;
			}
		}
		System.out.println(sum);
	}
}
