package workbook_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 수업_19700 {
    static int[][] a = new int[500005][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        //키로 내림차순하면 존재하는 팀에 들어가면 teamSize+1등
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0 ; i < n ; i++){
            int r= a[i][1];
            Integer teamSize = map.higherKey(-r); // 원하는 등수

            if(teamSize == null){ //등수보다 적은 teamSize가 없으면 새로운 팀 만들기
                map.put(-1, map.getOrDefault(-1,0)+1);
            }else{
                //등수 보다 적은 teamSize가 있어
                int value = map.get(teamSize);
                if(value == 1){ // 근데 한명이면 없애고 두명인 팀으로 만들기
                    map.remove(teamSize);
                }else { // 1명 초과면 한명 줄이고 해당 팀 사이즈 +1 해서 만들기
                    map.put(teamSize, value-1);
                }

                map.put(teamSize -1, map.getOrDefault(teamSize-1, 0)+1 );
            }
        }
        int ans = 0;
        for (int i : map.values()) {
            ans += i;
        }
        System.out.println(ans);
    }
}
