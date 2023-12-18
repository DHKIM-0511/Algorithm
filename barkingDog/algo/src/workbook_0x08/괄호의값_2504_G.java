package workbook_0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//https://www.acmicpc.net/problem/2504
public class 괄호의값_2504_G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int tmp = 1;
        for(int i = 0 ; i < input.length(); i++){
            char c = input.charAt(i);

            if(c == '('){
                tmp *=2;
                stack.push(c);
            }else if(c == '['){
                tmp *=3;
                stack.push(c);
            }else if (c == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    System.out.println(0);
                    return;
                }

                if(input.charAt(i-1) == '('){
                    ans +=tmp;
                }
                stack.pop();
                tmp /= 2;
            }
            else{
                if(stack.isEmpty() || stack.peek() != '['){
                    System.out.println(0);
                    return;
                }

                if(input.charAt(i-1) == '['){
                    ans+=tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }

    }
}
