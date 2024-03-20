package workbook_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,100000001});
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            int h = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < h ){
                stack.pop();
            }
            sb.append(stack.peek()[0]).append(" ");
            stack.push(new int[]{i,h});
        }
        System.out.println(sb);
    }
}
