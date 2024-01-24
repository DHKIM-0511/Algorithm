package solutions_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2_2751 {
    static int[] arr,tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N]; tmp = new int[N];
        
        for(int i = 0 ; i < N ; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        
        mergeSort(0,N);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void mergeSort(int left, int right) {
        if(left + 1 == right) return;
        int mid = (left+right)/2;
        mergeSort(left, mid);
        mergeSort(mid, right);
        merge(left,right);
    }

    private static void merge(int left, int right) {
        int mid =(left+right)/2;
        int lidx = left;
        int ridx = mid;

        for(int i =left ; i < right ; i++){
            if(ridx == right) tmp[i] = arr[lidx++];
            else if(lidx == mid) tmp[i] = arr[ridx++];
            else if(arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
            else tmp[i] = arr[ridx++];
        }
        for(int i = left ; i < right ; i++) arr[i] = tmp[i];
    }
}
