package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는수_1038 {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 10) {
            System.out.println(n);
            return;
        }

        for(int i = 0;  i < 10 ; i++){
            fnc(i,1);
        }

        if (n >= list.size()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);
        System.out.println(list.get(n));
    }

    private static void fnc(long num, int idx) {
        if(idx > 10){
            return;
        }

        list.add(num); // 감소하는 수 저장
        for(int i = 0 ; i < num % 10 ; i++){ // 감소하는 수 선별
            fnc((num*10)+i, idx + 1);
        }
    }
}
