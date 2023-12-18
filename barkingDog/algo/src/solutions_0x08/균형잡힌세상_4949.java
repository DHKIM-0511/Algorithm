package solutions_0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out: while(true){
            String input = br.readLine();

            if(input.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            int idx = 0;
            for(char c: input.toCharArray()){
                if(c == '(' || c == '['){
                    stack.push(c);
                } else if (c == ')' || c== ']') {
                    if(stack.isEmpty()){
                        System.out.println("no");
                        continue out;
                    }
                    char top = stack.pop();
                    if((c == ')' && top != '(') || (c == ']' && top != '[')){
                        System.out.println("no");
                        continue out;
                    }
                }
                idx++;
            }
            if (!stack.isEmpty()) {
                System.out.println("no");
            }else {
                System.out.println("yes");
            }
        }
    }
}
