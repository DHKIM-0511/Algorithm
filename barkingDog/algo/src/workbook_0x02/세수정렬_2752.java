package workbook_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세수정렬_2752 {

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int[] arr = new int[3];
       String[] input = br.readLine().split(" ");

       int idx= 0;
       int total = 0;
       for (String str : input){
           arr[idx] = Integer.parseInt(str);
           total += arr[idx++];
       }

       StringBuilder sb = new StringBuilder();
       int a = Math.min(Math.min(arr[0], arr[1]), arr[2]);
       int c = Math.max(Math.max(arr[0], arr[1]), arr[2]);
       int b = total - a - c;
       sb.append(a).append(" ");
       sb.append(b).append(" ");
       sb.append(c);

       System.out.println(sb);
   }
}
