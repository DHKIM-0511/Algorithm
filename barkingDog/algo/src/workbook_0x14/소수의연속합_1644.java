package workbook_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합_1644 {
    static int n;
    static boolean[] state = new boolean[4000005]; // false가 소수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 2; i *i <= 4000000 ; i++){
            if(state[i]) continue;
            for(int j = i*i ; j <= 4000000 ; j+=i){
                state[j] = true;
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for(int i = 2 ; i <= n ; i++) if(!state[i])primeList.add(i);

        int r = 0;
        int sum = 2;
        int cnt = 0;
        for(int l = 0 ; l < primeList.size() ; l++){
            while (r <primeList.size() && sum < n){
                r++;
                if(r != primeList.size()){
                    sum += primeList.get(r);
                }
            }
            if(r >= primeList.size()) break;
            if(sum == n){
                cnt++;
            }
            sum -= primeList.get(l);
        }
        System.out.println(cnt);
    }
}
