package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬디펜스_17135 {
    static int n,m,d;
    static int map[][];
    static int copy[][];
    static int arr[];
    static int turn;
    static int cnt=0;
    static int max=-1;
    static ArrayList<Node>enemy = new ArrayList<>();
    static Queue<Node>q = new LinkedList<>();   //궁수들의 위치
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        d = Integer.parseInt(t[2]);
        
        map = new int[n+1][m];
        copy = new int[n+1][m];
        arr = new int[3];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0,0);
        System.out.println(max);
    }
    
    public static void combi(int idx,int sidx) {
        if(sidx==3) {
        	for(int i=0; i<n; i++) { //맵 초기화
                for(int j=0; j<m; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            q.clear();
            for(int i=0; i<3; i++) {
                q.add(new Node(n,arr[i]));
            }
            cnt =0;
            turn = n;
            solve();
            return;
        }
        for(int i=idx; i<m; i++) {//조합으로 궁수 위치 선정
            arr[sidx]=i;
            combi(i+1,sidx+1);
        }
    }
    public static void solve() {
        while(turn !=0) {
            enemy.clear();
            for(int i=0; i<3; i++) {
                Node archer = q.poll();
                int x = archer.x;
                int y = archer.y;
                int tmpX=Integer.MAX_VALUE;
                int tmpY=Integer.MAX_VALUE;
                int tmpD=d;
                
                for(int j=x-1; j>=0; j--) {
                    for(int k=0; k<m; k++) {
                        if(copy[j][k]==1 && Math.abs(x-j)+Math.abs(y-k)<=tmpD) {
                            if(tmpD == Math.abs(x-j)+Math.abs(y-k)) {  // 거리가 같을때  가장 왼쪽 
                                if(tmpY>k) {
                                    tmpX=j;
                                    tmpY=k;
                                }
                            }
                            
                            else {  //if 문에 의해서 거리가 같은게 걸러지므로  최소거리
                                tmpD = Math.abs(x-j)+Math.abs(y-k);
                                tmpX=j;
                                tmpY=k;
                            }
                        }
                    }
                }
                q.add(new Node(x-1,y)); // 궁수 올리기
                if(tmpX !=Integer.MAX_VALUE && tmpY !=Integer.MAX_VALUE) { // 초기값과 다르면  = 적 선택
                    enemy.add(new Node(tmpX,tmpY));
                }
            }
            for(int i=0; i<enemy.size(); i++) { // 제외한 적 숫자 세기
                if(copy[enemy.get(i).x][enemy.get(i).y]==1) {
                    copy[enemy.get(i).x][enemy.get(i).y]=0;
                    cnt++;
                }
            }
            turn--;
        }
        max = Math.max(max, cnt);
    }
}
class Node{
    int x,y;
    Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}