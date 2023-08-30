package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값_2504 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int tmp = 1;
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        out : for (int i = 0; i < input.length; i++) {
            switch (input[i]) {

                case '(':
                    stack.push('(');
                    tmp *= 2;
                    break;

                case '[':
                    stack.push('[');
                    tmp *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        ans = 0;
                        break out;
                    }

                    if (input[i - 1] == '(') ans += tmp;
                    stack.pop();
                    tmp /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        ans = 0;
                        break out;
                    }

                    if (input[i - 1] == '[') ans += tmp;
                    stack.pop();
                    tmp /= 3;
                    break;
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : ans);
    }
}
