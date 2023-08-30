package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 창고다각형_2304 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());

		int[][] lh = new int[n][2];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			lh[i][0] = Integer.parseInt(st.nextToken());
			lh[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lh, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1 , int[] o2) {
				return o1[0] - o2[0]; // 0번열 = x좌표 기준 오름차순 정렬
			}
		});
		
		int startW = lh[0][0];
		int startH = lh[0][1];
		
		int sum = 0;
		int tmp = 0;
		
		for(int i = 1 ; i < n ; i++) {
			if(startH <= lh[i][1] ) {
				sum += (lh[i][0] - startW) * startH;
				startW = lh[i][0];
				startH = lh[i][1];
			}else if(startH <= lh[i][1]) {
				sum += startH;
				startW = lh[i][0];
			}

			else if(startH > lh[i][1]) {
				tmp = ((lh[i][0]+1)-(startW+1)) * lh[i][1] + startH;
			}
			else if( i == n-1  && startH == lh[i][1]) {
				sum += startH;
			}
			
		}
		System.out.println(sum+tmp);
	}
}
