package workbook;

import java.io.*;
import java.util.*;

public class 내일로여행_13168 {
    static final int INF = 0x3f3f3f3f;
    static final String[] type = {"S-Train", "V-Train", "ITX-Saemaeul", "ITX-Cheongchun", "Mugunghwa"}; //0, 1= 50 % ,2,3,4 = 무료
    static int n,r,m,k;
    static HashMap<String, Integer> cityNumber;
    static int[] tripCities;
    static int[][] normalMap, neailMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cityNumber = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            cityNumber.put(st.nextToken(), i);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        tripCities = new int[m];
        for(int i = 0 ; i < m ; i++) tripCities[i] = cityNumber.get(st.nextToken());

        normalMap = new int[n][n];
        neailMap = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(normalMap[i], INF);
            Arrays.fill(neailMap[i], INF);
            normalMap[i][i] = 0;
            neailMap[i][i] = 0;
        }
        k = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int s = cityNumber.get(st.nextToken());
            int e = cityNumber.get(st.nextToken());
            int pay = Integer.parseInt(st.nextToken())*2;

            normalMap[s][e] = Math.min(pay,normalMap[s][e]);
            normalMap[e][s] = Math.min(pay,normalMap[e][s]);
            if(noPay(type)){
                neailMap[s][e] = 0;
                neailMap[e][s] = 0;
            } else if (halfPay(type)) {
                neailMap[s][e] = Math.min(pay / 2, neailMap[s][e]);
                neailMap[e][s] = Math.min(pay / 2, neailMap[e][s]);
            } else{
                neailMap[s][e] = Math.min(pay,neailMap[s][e]);
                neailMap[e][s] = Math.min(pay,neailMap[e][s]);
            }
        }
        getMinDist();
        System.out.println(budgetDiff() > 0 ? "Yes" : "No");
    }

    private static void getMinDist() {
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(normalMap[i][j] > normalMap[i][k] + normalMap[k][j]){
                        normalMap[i][j] = normalMap[i][k] + normalMap[k][j];
                    }
                    if(neailMap[i][j] > neailMap[i][k] + neailMap[k][j]){
                        neailMap[i][j] = neailMap[i][k] + neailMap[k][j];
                    }
                }
            }
        }
    }

    private static int budgetDiff() {
        int diff = -(r*2);
        for(int i = 1; i < m ; i++){
            int s = tripCities[i-1];
            int e = tripCities[i];

            diff += normalMap[s][e];
            diff -= neailMap[s][e];
        }

        return diff;
    }
    private static boolean halfPay(String t) {
        return (t.equals(type[0]) || t.equals(type[1]));
    }

    private static boolean noPay(String t) {
        return (t.equals(type[2]) || t.equals(type[3]) ||t.equals(type[4]));
    }
}
