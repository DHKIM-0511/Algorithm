package silver2;

import java.io.*;
import java.util.*;

public class 단축키지정_1283 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        out : for(int tc = 0 ; tc < N ; tc++){
            String[] inputArr = br.readLine().split(" ");

            // 1. 단어의 첫 글자 확인
            for(int i = 0 ; i < inputArr.length ; i++){
            	
                if(!set.contains(inputArr[i].charAt(0))){
                	//대문자 , 소문자 저장
                    set.add(Character.toUpperCase(inputArr[i].charAt(0)));
                    set.add(Character.toLowerCase(inputArr[i].charAt(0)));

                    StringBuilder sb = new StringBuilder(inputArr[i]);
                    sb.insert(0, '[');
                    sb.insert(2, ']');
                    inputArr[i] = sb.toString();

                    printAnswer(inputArr);
                    continue out;
                }
            }

            // 2. 모든 단어의 첫 글자가 이미 지정되어 있다면, 왼쪽에서부터 차례대로 본다.
            for(int i = 0 ; i < inputArr.length ; i++){
                for(int j = 0 ; j < inputArr[i].length() ; j++){
                    if(!set.contains(inputArr[i].charAt(j))){
                    	
                        set.add(Character.toUpperCase(inputArr[i].charAt(j)));
                        set.add(Character.toLowerCase(inputArr[i].charAt(j)));

                        StringBuilder sb = new StringBuilder(inputArr[i]);
                        sb.insert(j, '[');
                        sb.insert(j+2, ']');
                        inputArr[i] = sb.toString();

                        printAnswer(inputArr);
                        continue out;
                    }
                }
            }
            printAnswer(inputArr);
        }
    }
	
    public static void printAnswer(String[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i++){
            if(i == arr.length - 1) sb.append(arr[i]);
            else sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
