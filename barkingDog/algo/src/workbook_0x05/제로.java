package workbook_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < K ; i++){
            int cur = Integer.parseInt(br.readLine());

            if(cur == 0){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(cur);
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        System.out.println(ans);
    }
}
