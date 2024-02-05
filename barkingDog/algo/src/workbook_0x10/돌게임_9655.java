package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임_9655 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(N % 2 == 0 ? "CY" : "SK");
    }
}
