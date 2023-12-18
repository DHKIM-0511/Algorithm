package workbook_0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int ans = 0;
        int tmp = 1;

        for(int i = 0 ; i < input.length(); i++){
            char c = input.charAt(i);

            if(c == '('){
                stack.push(c);
                tmp *=2;
            }else if(c == '['){
                stack.push(c);
                tmp*=3;
            }else if(c == ')'){
                if(stack.isEmpty()|| stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if(input.charAt(i-1) == '('){
                    ans += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else if (c == ']') {
                if(stack.isEmpty() || stack.peek() != '['){
                    System.out.println(0);
                    return;
                }
                if(input.charAt(i-1) == '['){
                    ans +=tmp;
                }
                stack.pop();
                tmp/=3;
            }
        }
        if(stack.isEmpty()){
            System.out.println(ans);
        } else {
            System.out.println(0);
        }
    }
}
