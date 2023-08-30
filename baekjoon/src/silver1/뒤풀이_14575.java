import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	 public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] input=new int[N][2];

        int leftsum = 0;
        int rightsum = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());

            leftsum += input[i][0];
            rightsum += input[i][1];
        }

        if( T < leftsum || rightsum < T){
            System.out.println(-1);
        }else {
        	
        	int left = 0;
        	int right = T;
        	
        	while(left<=right){
        		int mid = ( left + right ) / 2; // S
        		int sum = 0;
        		
        		boolean flag = false;
        		for(int i = 0; i < N ; i++){
        			//S값이 l보다 작으면 큰쪽part로 옮김
        			if(input[i][0] > mid){
        				flag = true;
        				break;
        			}
        			//l값을 더해서 비교하면 sum <T임 -> 큰쪽 part로 감 -> S의 최대값이 나옴
        			sum += Math.min(input[i][1],mid);
        		}
        		
        		if(flag){
        			left = mid + 1;
        			continue;
        		}
        		
        		if(sum >= T){
        			right = mid-1;
        		}
        		else{
        			left = mid+1;
        		}
        	}
        	System.out.println(left);
        }
    }
}