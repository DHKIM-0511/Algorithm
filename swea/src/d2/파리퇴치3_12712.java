package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치3_12712 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T ; tc++) {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 배열 크기
        int M = Integer.parseInt(st.nextToken());// 스프레이 세기

        int[][] arr = new int[N][N];
        
        for(int i=0;i<N;i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        
        int a = 0;
        int max = 0;
        int sum1 = 0;
        int sum2 = 0;
        int nc;
        int nr;
        int nc1;
        int nr1;
        
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ; c++) {
            	
               if(arr[r][c] >= 0 ) {
                   sum1 = arr[r][c];
                   sum2 = arr[r][c];
                   
                  for( a = 1 ; a < M ; a++) {
                	  
                    int[] dr1 = { 0 , 0, -a, a }; // 좌 우 상 하
                      int[] dc1 = { -a, a, 0 , 0 };
                      
                      int[] dr2 = { -a, -a , a, a}; // 각 대각선
                      int[] dc2 = { a, -a, -a, a};
                      
                      for(int b = 0 ; b < 4 ; b++) {
                          nr = r + dr1[b];
                          nc = c + dc1[b]; 
                          
                          nr1 = r + dr2[b];
                          nc1 = c + dc2[b];
                          
                          if( nr >= 0 && nr < N && nc>= 0 && nc<N) {
                             sum1 += arr[nr][nc];
                          }  
                          if (nr1>=0 && nr1<N && nc1>= 0 && nc1<N) {
                             sum2 += arr[nr1][nc1];
                          }
                      }
               }
                  
               if(sum1 > max) max = sum1;
               if(sum2 > max) max = sum2;

               }
            }
        }
        System.out.println("#"+tc+" "+max);
    }

}
}
