package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수묶기_1744 {
    static int N;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> pNum = new ArrayList<>();
        List<Integer> mNum = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if ( num == 1 ) ans++;
            else if( num > 0 ) pNum.add(num);
            else mNum.add(num);
        }
        Collections.sort(pNum);
        Collections.sort(mNum, Collections.reverseOrder());

        getSum(pNum);
        getSum(mNum);
        System.out.println(ans);
    }

    private static void getSum(List<Integer> numList) {
        while (numList.size() > 1){
            int l = numList.size();
            ans += (long)numList.get(l - 1) * numList.get(l - 2);
            numList.remove(l - 1);
            numList.remove(l - 2);
        }
        if(!numList.isEmpty()) ans += numList.get(0);
    }
}
