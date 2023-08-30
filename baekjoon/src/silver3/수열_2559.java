package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_2559 {
	public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temp = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += temp[i]; // k = 2 일때 0 , 1 번의 합 저장
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - temp[i - k] + temp[i]; //  0 , 1번에서 0 번 빼고 2번을 더한값 저장 하면 서 최대값 저장
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }
}
