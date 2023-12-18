package workbook_0x02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 카드역배치_10804 {
    static int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 10 ; i++){
            String[] section = br.readLine().split(" ");
            int a = Integer.parseInt(section[0])-1;
            int b = Integer.parseInt(section[1])-1;
            reverse(a,b);
        }
        for (int i : input){
            System.out.print(i+" ");
        }
    }
    static void reverse(int a, int b){
        Stack<Integer> stack = new Stack<>();

        for(int i = a ; i <= b ; i++){
            stack.push(input[i]);
        }

        for(int i = a ; i <= b ; i++){
            input[i] = stack.pop();
        }
    }
}
