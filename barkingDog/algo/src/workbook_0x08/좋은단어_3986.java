package workbook_0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            String input = br.readLine();
            if(input.length() % 2==1) continue ;

            Stack<Character> stack = new Stack<>();
            stack.push(input.charAt(0));

            for(int j = 1 ; j < input.length() ; j++){
                char c = input.charAt(j);
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
