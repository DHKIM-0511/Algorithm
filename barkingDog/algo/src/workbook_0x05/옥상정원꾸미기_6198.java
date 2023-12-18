package workbook_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 옥상정원꾸미기_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }
            stack.push(h);
            result += stack.size() - 1;
        }

        System.out.println(result);
    }
}
