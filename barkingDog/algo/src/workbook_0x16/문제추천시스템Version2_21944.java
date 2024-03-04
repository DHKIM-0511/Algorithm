package workbook_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 문제추천시스템Version2_21944 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[100002][2];
        TreeSet<Integer>[] wholeSet = new TreeSet[102];
        TreeSet<Integer>[][] set = new TreeSet[102][102];
        for(int i = 0 ; i < 101 ; i ++){
            wholeSet[i] = new TreeSet<>();
            for(int j = 0 ; j < 102 ; j++)set[i][j] = new TreeSet<>();
        }

        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int p= Integer.parseInt(st.nextToken());
            int l= Integer.parseInt(st.nextToken());
            int g= Integer.parseInt(st.nextToken());

            set[g][l].add(p);
            wholeSet[l].add(p);
            arr[p] = new int[]{l,g};
        }

        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        while (m-- >0){
            st= new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if(type.charAt(0) == 'r'){
                if(type.charAt(type.length()-1) == '2'){
                    int x = Integer.parseInt(st.nextToken());
                    if(x == 1){
                        for(int i = 100 ; i >= 0 ; i-- ){
                            if(wholeSet[i].isEmpty())continue;
                            sb.append(wholeSet[i].last()).append("\n");
                            break;
                        }
                    }
                    else{
                        for(int i = 0 ; i < 101 ; i++){
                            if(wholeSet[i].isEmpty())continue;
                            sb.append(wholeSet[i].first()).append("\n");
                            break;
                        }
                    }
                }else if(type.charAt(type.length()-1) == '3'){
                    int x = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    int p = -1;
                    if(x == 1){
                        for(int i = l ; i < 101 ; i++){
                            if(wholeSet[i].isEmpty())continue;
                            p=wholeSet[i].first();
                            break;
                        }
                    }else {
                        for(int i = l-1 ; i >= 0 ; i--){
                            if(wholeSet[i].isEmpty())continue;
                            p=wholeSet[i].last();
                            break;
                        }
                    }
                    sb.append(p).append("\n");
                }else {
                    int g = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());

                    if(x == 1) {
                        for(int i = 100 ; i >= 0 ; i--){
                            if(set[g][i].isEmpty())continue;
                            sb.append(set[g][i].last()).append("\n");
                            break;
                        }
                    }
                    else {
                        for(int i = 0 ; i <101 ; i++){
                            if(set[g][i].isEmpty())continue;
                            sb.append(set[g][i].first()).append("\n");
                            break;
                        }
                    }
                }
            }else if(type.charAt(0) == 'a'){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                arr[p] = new int[]{l,g};
                wholeSet[l].add(p);
                set[g][l].add(p);
            }else {
                int p = Integer.parseInt(st.nextToken());
                int l = arr[p][0];
                int g = arr[p][1];

                wholeSet[l].remove(p);
                set[g][l].remove(p);
            }
        }
        System.out.println(sb);
    }
}
