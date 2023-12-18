package workbook_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 요세푸스문제_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> list = new LinkedList<>();
        for(int i =1 ; i <= N ; i++) list.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 0;
        while (list.size() > 1){
            idx = (idx+(K-1)) % list.size();

            sb.append(list.remove(idx)).append(", ");
        }
        sb.append(list.remove(0)).append(">");
        System.out.println(sb);
    }
}
