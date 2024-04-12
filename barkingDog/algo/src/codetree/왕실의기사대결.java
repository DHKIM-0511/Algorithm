package codetree;

import java.util.*;
import java.io.*;
public class 왕실의기사대결 {
	// Directions: up, right, down, left
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    
    static int[][] arr;
    static Map<Integer, int[]> units = new HashMap<>();
    static int[] init_k;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        
        // Initialize the map with borders (walls)
        arr = new int[N + 2][N + 2];
        for (int[] row : arr)
            Arrays.fill(row, 2);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        init_k = new int[M + 1];
        for (int m = 1; m <= M; m++) {
            int si = sc.nextInt(), sj = sc.nextInt(), h = sc.nextInt(), w = sc.nextInt(), k = sc.nextInt();
            units.put(m, new int[]{si, sj, h, w, k});
            init_k[m] = k;
        }
        
        for (int i = 0; i < Q; i++) {
            int idx = sc.nextInt(), dr = sc.nextInt();
            if (units.containsKey(idx)) {
                pushUnit(idx, dr);
            }
        }
        
        int ans = 0;
        for (int idx : units.keySet()) {
            ans += init_k[idx] - units.get(idx)[4];
        }
        System.out.println(ans);
    }
    
    public static void pushUnit(int start, int dr) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> pset = new HashSet<>();
        int[] damage = new int[units.size() + 1];
        
        q.add(start);
        pset.add(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] unit = units.get(cur);
            int ci = unit[0], cj = unit[1], h = unit[2], w = unit[3], k = unit[4];
            
            int ni = ci + di[dr], nj = cj + dj[dr];
            for (int i = ni; i < ni + h; i++) {
                for (int j = nj; j < nj + w; j++) {
                    if (arr[i][j] == 2) return;
                    if (arr[i][j] == 1) damage[cur]++;
                }
            }
            
            for (int idx : units.keySet()) {
                if (pset.contains(idx)) continue;
                
                int[] otherUnit = units.get(idx);
                int ti = otherUnit[0], tj = otherUnit[1], th = otherUnit[2], tw = otherUnit[3];
                
                if (ni <= ti + th - 1 && ni + h - 1 >= ti && nj <= tj + tw - 1 && nj + w - 1 >= tj) {
                    q.add(idx);
                    pset.add(idx);
                }
            }
        }
        
        damage[start] = 0;
        
        for (int idx : new HashSet<>(pset)) {
            int[] unit = units.get(idx);
            int si = unit[0], sj = unit[1], h = unit[2], w = unit[3], k = unit[4];
            
            if (k <= damage[idx]) {
                units.remove(idx);
            } else {
                int ni = si + di[dr], nj = sj + dj[dr];
                units.put(idx, new int[]{ni, nj, h, w, k - damage[idx]});
            }
        }
    }
}
