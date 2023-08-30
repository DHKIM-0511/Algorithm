package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀의귀재{
	static int cnt;
	
    public static int recursion(String s, int l, int r){
    	cnt++;
    	if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int t = Integer.parseInt(br.readLine());
        
        for(int tc = 0 ; tc < t ; tc++) {
        	cnt=0;
        	System.out.println(isPalindrome(br.readLine())+" "+cnt);
        }
    }
}